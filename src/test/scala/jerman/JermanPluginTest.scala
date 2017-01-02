package jerman

import org.scalatest.{FlatSpec, Matchers}


class JermanPluginTest extends FlatSpec with Matchers with JermanTestFixtures {


  "Plugin" should "compile all jerman files to java files in dest dir" in  withFiles { rootDir =>
    withEmptyDir { destDir =>
      val plugin = JermanPlugin()
      val javaFiles = plugin.compileAll(rootDir.toFile, destDir.toFile)
      javaFiles should have length 3
      javaFiles.map(_.getName) should contain allOf("x.java", "y.java", "z.java")
      javaFiles map (_.toString) map { s => s should startWith(destDir.toString()) }
    }
  }

}
