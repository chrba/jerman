package jerman

import java.nio.file.{Files, Path, Paths}

/**
  * Created by cbannes on 31.12.16.
  */
trait JermanTestFixtures extends ARM {
  def withFiles(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), rootDir => {
      val subdir1 = Files.createDirectories(rootDir.resolve("subdir1"))
      val subdir2 = Files.createDirectories(rootDir.resolve("subdir2"))


      val jermanFile = Paths.get(getClass().getResource("/Beispiel.jerman").toURI())
      Files.copy(jermanFile, rootDir.resolve("x.jerman"))
      Files.copy(jermanFile, subdir1.resolve("y.jerman"))
      Files.copy(jermanFile, subdir2.resolve("z.jerman"))
      testCode(rootDir)
    })
  }

  def withSingleFile(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), rootDir => {
      val jermanFile = Paths.get(getClass().getResource("/Beispiel.jerman").toURI())
      Files.copy(jermanFile, rootDir.resolve("x.jerman"))
      testCode(rootDir)
    })
  }

  def withEmptyDir(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), dir => {
      testCode(dir)
    })
  }

  def withJermanFile(testCode: Path => Any) {
    autoClean(Files.createTempDirectory("scalatest-"), dir => {
      val file = Paths.get(getClass().getResource("/Beispiel.jerman").toURI())
      testCode(file)
    })
  }
}
