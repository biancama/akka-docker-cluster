

name := "akka-docker"

//version := "2.4-M2"
//
//scalaVersion := "2.11.6"
//
//libraryDependencies ++= Seq(
//  "com.typesafe.akka" %% "akka-actor" % version.value,
//  "com.typesafe.akka" %% "akka-cluster" % version.value,
//  "com.github.scopt" %% "scopt" % "3.2.0"
//)
//

// Create custom run tasks to start a seed and a cluster node
// http://www.scala-sbt.org/0.13.0/docs/faq.html#how-can-i-create-a-custom-run-task-in-addition-to-run
//lazy val runSeed = taskKey[Unit]("Start the seed node on 127.0.0.1:2551")
//
//fullRunTask(runSeed, Compile, "com.example.Main", "--seed")
//
//fork in runSeed := true
//
//javaOptions in runSeed ++= Seq(
//    "-Dclustering.ip=127.0.0.1",
//    "-Dclustering.port=2551"
//)
//
//lazy val runNode = taskKey[Unit]("Start a node on 127.0.0.1:2552")
//
//fullRunTask(runNode, Compile, "com.example.Main", "127.0.0.1:2551")
//
//fork in runNode := true
//
//javaOptions in runNode ++= Seq(
//    "-Dclustering.ip=127.0.0.1",
//    "-Dclustering.port=2552"
//)
version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "1.2.0"
  // -- testing --
  , "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"
  // -- Logging --
  ,"ch.qos.logback" % "logback-classic" % "1.1.1" ,
  "com.typesafe.akka" % "akka-actor_2.11" % "2.4-M2" withSources(),
  "com.typesafe.akka" % "akka-remote_2.11" % "2.4-M2",
  "com.typesafe.akka" % "akka-slf4j_2.11" % "2.4-M2",
  "com.typesafe.akka" % "akka-cluster_2.11" % "2.4-M2" withSources(),
  "com.github.scopt" %% "scopt" % "3.3.0"
)

maintainer := "Massimo Biancalani <massimo.biancalani@gmail.com>"

dockerExposedPorts in Docker := Seq(5150)

//dockerEntrypoint in Docker := Seq("sh", "-c", "CLUSTER_IP=`/sbin/ifconfig eth0 | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1 }'` bin/clustering $*")

dockerRepository := Some("biancama")

Keys.mainClass in (Compile) := Some("com.example.Main")

dockerBaseImage := "java"

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)