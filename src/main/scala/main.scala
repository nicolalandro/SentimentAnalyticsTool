import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, NoDependencyResolver}

object main extends JFXApp {
stage = new PrimaryStage() {
    title = "Home"
    scene = new Scene(FXMLView(getClass.getClassLoader.getResource("home.fxml"), NoDependencyResolver))
  }
}
