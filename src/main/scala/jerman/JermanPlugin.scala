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

  val jermanSrcDir = (sourceDirectory in Compile).value / "jerman"

  override lazy val projectSettings = Seq(
    jermanVersion := "1.0",
    unmanagedSourceDirectories in Compile += jermanSrcDir,
    sourceGenerators in Compile += Def.task {
      val log = streams.value.log
      log.info("compiling jerman sources...")

      val managedSrcDir = (sourceManaged in Compile).value / "java"
      compileAll(jermanSrcDir, managedSrcDir)
    }.taskValue
  )
}