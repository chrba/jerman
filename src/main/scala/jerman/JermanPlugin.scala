package jerman
import java.io.File

import sbt.Keys._
import sbt.{AutoPlugin, Level, Logger, _}

object JermanPlugin extends AutoPlugin with Transpiler {
  override def requires = sbt.plugins.JvmPlugin
  override def trigger = allRequirements

  object autoImport {
    lazy val jermanVersion = SettingKey[String]("jermanVersion", "the jerman version")
  }
  import autoImport._

  override lazy val projectSettings = Seq(
    jermanVersion := "1.0",
    watchSources <++= baseDirectory map { path => ((path / "src/main/jerman") ** "*.jerman").get },
    sourceGenerators in Compile += Def.task {
      val log = streams.value.log
      log.info("compiling jerman sources...")
      val jermanSrcDir = (sourceDirectory in Compile).value / "jerman"
      val managedSrcDir = (sourceManaged in Compile).value / "java"
      compileAll(jermanSrcDir, managedSrcDir)
    }.taskValue
  )
}