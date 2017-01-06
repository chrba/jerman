sbtPlugin := true

organization := "de.jerman"

name := "jerman"

version := "1.1"

scalaVersion := "2.10.4"

//sourceGenerators in Compile += Def.task {
//  //val file = (sourceManaged in Compile).value / "demo" / "Test.scala"
//  //IO.write(file, """object Test extends App { println("Hi") }""")
// // Seq(file)
//
//  val jermanBase = (baseDirectory in Compile).value / "src" / "main" / "jerman"
//  val file = jermanBase / "Test.java"
//  Seq(file)
//
//}.taskValue

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"