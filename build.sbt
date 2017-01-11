import bintray.Keys._
import sbt.Keys._

lazy val commonSettings = Seq(
  version in ThisBuild := "1.0.1",
  organization in ThisBuild := "de.jerman"
)

lazy val root = (project in file(".")).
  settings(commonSettings ++ bintrayPublishSettings: _*).
  settings(
    sbtPlugin := true,
    scalaVersion := "2.10.4",
    name := "jerman",
    description := "jerman plugin",
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    publishMavenStyle := false,
    repository in bintray := "sbt-plugins",
    bintrayOrganization in bintray := None,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)




