name := "comet-presentation"

version := "0.2"

organization := "com.fmpwizard"

scalaVersion := "2.9.1"

seq(webSettings :_*)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= {
val liftVersion = "2.5-SNAPSHOT"
  Seq(
  "net.liftweb"       %% "lift-webkit" % liftVersion % "compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "ch.qos.logback"    % "logback-classic" % "0.9.26",
  "net.liftmodules"   %% "fobo"        % (liftVersion+"-0.7.7-SNAPSHOT")
  )
}

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"


