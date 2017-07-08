import java.io.File
import java.net.URL
import java.nio.file.Paths

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, NoDependencyResolver}


object MainObject extends JFXApp {
  stage = new PrimaryStage() {
    title = "Home"
    scene = new Scene(FXMLView(getFXMLFromJarFolder("home.fxml"), NoDependencyResolver))
  }
  println(getClass.getProtectionDomain.getCodeSource.getLocation.toURI.getPath)

  def getFXMLFromJarFolder(s: String): URL = {
//    new URL("file://"+getClass.getProtectionDomain.getCodeSource.getLocation.toURI.getPath + s)
    val absolutePath:String = Paths.get(getClass.getProtectionDomain.getCodeSource.getLocation.toURI.getPath).toString
    val file = new File(absolutePath)
    val path = file.getParentFile.getAbsolutePath
    println(absolutePath)
    println(path)
    new URL("file://"+path+"/FXML/"+s)
  }
}
