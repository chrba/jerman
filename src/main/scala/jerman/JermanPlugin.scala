package jerman
import java.io.File

import sbt.Keys._
import sbt.AutoPlugin
import sbt._

object JermanPlugin extends AutoPlugin with Transpiler {
  override def requires = sbt.plugins.JvmPlugin
  override def trigger = allRequirements

  object autoImport {
    lazy val jermanVersion = SettingKey[String]("jermanVersion", "the jerman version")
  }
  import autoImport._

  override lazy val projectSettings = Seq(
    jermanVersion := "1.0",
    sourceGenerators in Compile += Def.task {
      println("compiling jerman sources...")
      val jermanSrcDir = (sourceDirectory in Compile).value / "jerman"
      val managedSrcDir = (sourceManaged in Compile).value / "java"
      compileAll(jermanSrcDir, managedSrcDir)
    }.taskValue
  )
}