name := "emklatz"

version := "0.1"

scalaVersion := "2.12.8"

mainClass := Some("velet5.emklatz.Application")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.1.7",
  "com.typesafe.akka" %% "akka-actor" % "2.5.19",
  "com.typesafe.akka" %% "akka-stream" % "2.5.19",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  "org.typelevel" %% "cats-core" % "1.5.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.github.pureconfig" %% "pureconfig" % "0.10.1"
)
