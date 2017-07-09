import java.awt.Robot
import java.awt.event.InputEvent
import java.io.File
import javafx.application.Platform
import javafx.scene.Node
import javafx.scene.chart.PieChart
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javax.xml.bind.{JAXBContext, Marshaller}

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

class HomePageTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  var m = MainObject
  val bot = new Robot()

  override protected def beforeEach(): Unit = {
    m = MainObject

    new Thread(new Runnable {
      override def run(): Unit = m.main(Array())
    }).start()

    Thread.sleep(4000)
  }

  override protected def afterEach(): Unit = {
    var file: File = new File("data.xml")
    var jaxbContext = JAXBContext.newInstance(classOf[SentimentIterationData])
    var jaxbMarshaller = jaxbContext.createMarshaller
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
    jaxbMarshaller.marshal(new SentimentIterationData, file)

    //chiudere l'app
  }


  it should "click on mood 0" in {
    val label = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(0)
    val chart = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(2).asInstanceOf[PieChart]

    val hbox = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(1).asInstanceOf[HBox]

    val button0 = hbox.getChildrenUnmodifiable.get(0).asInstanceOf[Button]
    val button1 = hbox.getChildrenUnmodifiable.get(1).asInstanceOf[Button]
    val button2 = hbox.getChildrenUnmodifiable.get(2).asInstanceOf[Button]
    val button3 = hbox.getChildrenUnmodifiable.get(3).asInstanceOf[Button]
    val button4 = hbox.getChildrenUnmodifiable.get(4).asInstanceOf[Button]

    clickOn(button0)
    clickOn(button1)
    clickOn(button2)
    clickOn(button3)
    clickOn(button4)

    Platform.runLater(new Runnable {
      override def run(): Unit = {
        chart.getData.get(0).getPieValue should be(1.0)
        chart.getData.get(1).getPieValue should be(1.0)
        chart.getData.get(2).getPieValue should be(1.0)
        chart.getData.get(3).getPieValue should be(1.0)
        chart.getData.get(4).getPieValue should be(1.0)
      }
    })

  }


  it should "click on mood 1" in {
    val chart = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(2).asInstanceOf[PieChart]
    val hbox = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(1).asInstanceOf[HBox]

    val button1 = hbox.getChildrenUnmodifiable.get(1).asInstanceOf[Button]

    clickOn(button1)

    Platform.runLater(new Runnable {
      override def run(): Unit = {
        chart.getData.get(1).getPieValue should be(1.0)
      }
    })
  }

  def clickOn(n: Node): Unit = {
    val boundsLocal = n.getBoundsInLocal
    val bounds = n.localToScreen(boundsLocal)

    val x: Int = Math.ceil(bounds.getMinX + (bounds.getMaxX - bounds.getMinX) / 2).asInstanceOf[Int]
    val y: Int = Math.ceil(bounds.getMinY + (bounds.getMaxY - bounds.getMinY) / 2).asInstanceOf[Int]

    bot.mouseMove(x, y)
    bot.mousePress(InputEvent.BUTTON1_MASK)
    bot.mouseRelease(InputEvent.BUTTON1_MASK)
  }

}
