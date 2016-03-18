name := """kataAnalyzer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "com.typesafe.play" %% "play-mailer" % "4.0.0-M1"
)

herokuAppName in Compile := "fathomless-stream-54754"
