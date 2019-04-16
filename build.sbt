name := """play-java-forms-example"""

version := "2.7.x"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

libraryDependencies += guice

libraryDependencies += "org.webjars.bower" % "compass-mixins" % "0.12.7"

libraryDependencies += "org.webjars.bower" % "bootstrap-sass" % "3.3.6"

javacOptions ++= Seq(
  "-Xlint:unchecked",
  "-Xlint:deprecation"
) 
