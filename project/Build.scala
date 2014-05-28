import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "securesocial-sample"
    val appVersion      = "1.0"

    val appDependencies = Seq(
	javaCore,
        "ws.securesocial" %% "securesocial" % "master-SNAPSHOT"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
	resolvers += Resolver.sonatypeRepo("snapshots")
    )

}