sbtPlugin := true

organization := "de.jerman"

name := "jerman"

version := "1.0.1"

scalaVersion := "2.10.4"

publishM2 := {
  publishM2.value

  val d = file(sys.env("HOME")) / s".m2/repository/de/jerman/jerman_${scalaBinaryVersion.value}_${sbtBinaryVersion.value}"
  d.renameTo(file(sys.env("HOME")) / ".m2/repository/de/jerman/jerman")
}

publishMavenStyle := true

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
