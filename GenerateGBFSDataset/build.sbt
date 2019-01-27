name := "GenerateGBFSDataset"

version := "0.1"

//scalaVersion := "2.12.8"
scalaVersion := "2.11.8"

//Compile/mainClass := Some("com.david.GenerateGBFS.main.Main")

//libraryDependencies += "com.github.agourlay" %% "json-2-csv" % "0.4.1"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.6"
libraryDependencies += "org.json" % "json" % "20180813"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.4"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.4"
libraryDependencies += "commons-io" % "commons-io" % "2.6"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0" % "provided"
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.7"
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.7"


libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

assemblyJarName in assembly := "GenerateGBFSDataset.jar"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}