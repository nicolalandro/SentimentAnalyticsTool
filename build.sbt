name := "SentimentAnalyticsTool"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.102-R11",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.3"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.0-b170201.1204"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

//libraryDependencies += "org.testfx" % "testfx-core" % "4.0.6-alpha" % "test"
//libraryDependencies += "org.testfx" % "testfx-junit" % "4.0.6-alpha" % "test"
//libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.0.0-M1" % "test"

//libraryDependencies += "com.lambdaworks" %% "jacks" % "2.3.3"
//libraryDependencies +="com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.2"