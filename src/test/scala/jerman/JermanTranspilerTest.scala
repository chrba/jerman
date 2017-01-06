package jerman

import java.nio.file._

import org.scalatest.{FlatSpec, Matchers}

class JermanTranspilerTest extends FlatSpec with Matchers with JermanTestFixtures {

  "JermanCompiler" should "compile jerman file to output directory" in withJermanFile { jermanFile =>
    withEmptyDir { emptyDir =>
      val compiler = new JermanTranspiler with KeywordMapper
      val javaFile = compiler.compile(jermanFile, emptyDir)

      javaFile.toFile should be a 'file
      javaFile.toFile.getName should endWith (".java")
      Files.size(javaFile).toInt should be > 0
    }
  }

}
