package jerman

import org.scalatest.{FlatSpec, Matchers}


class JermanFileLocatorTest extends FlatSpec with Matchers with JermanTestFixtures {

  "All files" should "be scanned in the given directory" in withFiles { rootDir =>
    val jermanFileLocator = new JermanFileLocator() {}
    val jermanFiles = jermanFileLocator.find(rootDir)
    val fileNames = jermanFiles.map(_.toFile.getName)
    jermanFiles should have length 3
    fileNames should contain allOf ("x.jerman", "y.jerman", "z.jerman")
  }
}
