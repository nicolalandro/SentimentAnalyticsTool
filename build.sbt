name := "SentimentAnalyticsTool"

version := "1.0"

scalaVersion := "2.11.6"

//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
//
//libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.3"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.102-R11",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.3"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)



libraryDependencies += "com.lambdaworks" %% "jacks" % "2.3.3"
