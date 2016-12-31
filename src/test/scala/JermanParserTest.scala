import org.scalatest.{FlatSpec, Matchers}
import java.nio.file._


class JermanParserTest extends FlatSpec with Matchers with ARM {

  def withFiles(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), rootDir => {
      val subdir1 = Files.createDirectories(rootDir.resolve("subdir1"))
      val subdir2 = Files.createDirectories(rootDir.resolve("subdir2"))


      val jermanFile = Paths.get(getClass().getResource("Beispiel.jerman").toURI())
      Files.copy(jermanFile, rootDir.resolve("x.jerman"))
      Files.copy(jermanFile, subdir1.resolve("y.jerman"))
      Files.copy(jermanFile, subdir2.resolve("z.jerman"))
      testCode(rootDir)
    })
   }

  def withSingleFile(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), rootDir => {
      val jermanFile = Paths.get(getClass().getResource("Beispiel.jerman").toURI())
      Files.copy(jermanFile, rootDir.resolve("x.jerman"))
      testCode(rootDir)
    })
  }

  def withEmptyDir(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), dir => {
      testCode(dir)
    })
  }

  "All files" should "be scanned in the given directory" in withFiles { rootDir =>
    val jermanFileLocator = new JermanFileLocator() {}
    val jermanFiles = jermanFileLocator.find(rootDir)
    val fileNames = jermanFiles.map(_.toFile.getName)
    jermanFiles should have length 3
    fileNames should contain oneOf ("x.jerman", "y.jerman", "z.jerman")
  }



  it should "lead to a corresponding java file in dest dir" in  withFiles { rootDir =>
    withEmptyDir { destDir =>
      val jermanCompiler = new JermanPlugin with KeywordMapper with JermanFileLocator
      val javaFiles = jermanCompiler.compile(rootDir, destDir)

      javaFiles should have length 3
      javaFiles.map(p => p.toFile.getName) should contain oneOf("x.java", "y.java", "z.java")
      javaFiles map (p => p.toString) map { s => s should startWith(destDir.toString()) }
    }
  }

  "Compiler" should "compile jerman file to java file" in withSingleFile { jermanFile =>
      withEmptyDir {  destDir =>
          val jermanCompiler = new JermanCompiler()
          Path javaFile = jermanCompiler.compile(jermanFile, destDir)

      }
  }


}
