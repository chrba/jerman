sbtPlugin := true

organization := "de.jerman"

name := "jerman"

version := "1.8"

scalaVersion := "2.10.4"

/*
sourceGenerators in Compile += Def.task {
  val jermanSrcDir = (sourceDirectory in Compile).value / "jerman"
  val javaSrcDir = (sourceDirectory in Compile).value / "java"
  println(s"jerman source directory=$jermanSrcDir")
  Seq()
}.taskValue
*/

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"