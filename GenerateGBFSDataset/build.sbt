name := "GenerateGBFSDataset"

version := "0.1"

scalaVersion := "2.12.8"

Compile/mainClass := Some("com.david.GenerateGBFS.main.Main")

libraryDependencies += "com.github.agourlay" %% "json-2-csv" % "0.4.1"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.6"
libraryDependencies += "org.json" % "json" % "20180813"
libraryDependencies += "commons-io" % "commons-io" % "2.6"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

assemblyJarName in assembly := "GenerateGBFSDataset.jar"