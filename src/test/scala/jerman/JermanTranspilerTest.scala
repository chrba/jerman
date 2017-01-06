package jerman

import java.nio.file._

import org.scalatest.{FlatSpec, Matchers}

class JermanTranspilerTest extends FlatSpec with Matchers with JermanTestFixtures {

  "JermanTranspiler" should "compile jerman file to output directory" in withJermanFile { jermanFile =>
    withEmptyDir { emptyDir =>
      val transpiler = new JermanTranspiler with KeywordMapper
      val javaFile = transpiler.compile(jermanFile, emptyDir)

      javaFile.toFile should be a 'file
      javaFile.toFile.getName should endWith (".java")
      Files.size(javaFile).toInt should be > 0
    }
  }

}
