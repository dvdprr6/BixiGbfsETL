name := "GenerateGBFSDataset"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.6"
libraryDependencies += "org.json" % "json" % "20180813"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.4"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.4"
libraryDependencies += "commons-io" % "commons-io" % "2.6"

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.7"
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.7"


libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

assemblyJarName in assembly := "GenerateGBFSDataset.jar"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}