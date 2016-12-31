name := "jerman"

version := "1.0"

scalaVersion := "2.12.0"

sourceGenerators in Compile += Def.task {
  val file = (sourceManaged in Compile).value / "demo" / "Test.scala"
  IO.write(file, """object Test extends App { println("Hi") }""")
  Seq(file)
}.taskValue

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"