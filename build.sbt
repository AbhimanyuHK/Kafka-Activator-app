name := """Kafka-Comsumer-process"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  javaWs,
  "org.apache.kafka" % "kafka_2.11" % "0.10.2.1",
  "org.apache.kafka" % "kafka-streams" % "1.0.0",
  "com.github.abel533" % "EasyXls" % "1.0.0",
  "org.apache.poi" % "poi" % "3.17",
  "junit" % "junit" % "4.8" % "test"
)

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes
