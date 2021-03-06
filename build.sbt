sbtPlugin := true

organization := "com.typesafe"

name := "sbt-web"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "com.assembla.scala-incubator" %% "graph-core" % "1.7.0",
  "org.scala-lang" %% "scala-pickling" % "0.8.0-SNAPSHOT",
  "org.specs2" %% "specs2" % "2.2.2" % "test",
  "junit" % "junit" % "4.11" % "test"
  )

publishMavenStyle := false

publishTo := {
    val isSnapshot = version.value.contains("-SNAPSHOT")
    val scalasbt = "http://repo.scala-sbt.org/scalasbt/"
    val (name, url) = if (isSnapshot)
                        ("sbt-plugin-snapshots", scalasbt + "sbt-plugin-snapshots")
                      else
                        ("sbt-plugin-releases", scalasbt + "sbt-plugin-releases")
    Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}
