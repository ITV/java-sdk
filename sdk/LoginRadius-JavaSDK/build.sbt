
// define the statements initially evaluated when entering 'console', 'console-quick', but not 'console-project'
javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

libraryDependencies ++= Seq(
  "com.google.code.gson" % "gson" % "2.2.4",
  "javax.servlet" % "servlet-api" % "2.5",
  "commons-codec" % "commons-codec" % "1.11",
  "org.scalatest"     %% "scalatest"   % "3.0.3" % Test withSources(),
  "junit"             %  "junit"       % "4.12"  % Test
)

// If you want to apply a license, such as the Apache 2 license, uncomment the following:
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

logLevel := Level.Warn

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

// Level.INFO is needed to see detailed output when running tests
logLevel in test := Level.Info

name := "lradius-java-sdk" // TODO provide a short yet descriptive name

organization := "com.itv"

version := "4.1.2"

publishMavenStyle := true

publishTo in ThisBuild := Some("itvrepos" at "http://itvrepos.jfrog.io/itvrepos/user-libs")

val credentialsLocation: RichFile =
  sys.props.get("credentials.location").map(Path(_)).getOrElse(Path.userHome / ".ivy2" / ".user-credentials")

credentials += Credentials(credentialsLocation.asFile)

