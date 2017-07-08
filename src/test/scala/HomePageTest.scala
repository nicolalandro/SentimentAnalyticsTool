import javafx.scene.layout.HBox

import org.scalatest.{FlatSpec, Matchers}

import javafx.scene.control.Button

class HomePageTest extends FlatSpec with Matchers {

  it should "start main" in {
    var m = MainObject

    new Thread(new Runnable {
      override def run(): Unit = m.main(Array())
    }).start()

    println("Before: " + m.stage)
    Thread.sleep(4000)
//    var x = m.stage
//    while(x == null){
//      print(x)
//    }
    println("After: " + m.stage)

    val label = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(0)
    val chart = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(2)

    val hbox = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(1).asInstanceOf[HBox]

    val button0 = hbox.getChildrenUnmodifiable.get(0).asInstanceOf[Button]

    button0.fire()

    Thread.sleep(4000)
  }

}
