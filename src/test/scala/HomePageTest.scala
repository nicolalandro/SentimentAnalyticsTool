import java.io.File
import javafx.scene.layout.HBox

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}
import javafx.scene.chart.PieChart
import javafx.scene.control.Button
import javax.xml.bind.{JAXBContext, Marshaller}

class HomePageTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  var m = MainObject

  override protected def beforeEach(): Unit = {
    new Thread(new Runnable {
      override def run(): Unit = m.main(Array())
    }).start()

    Thread.sleep(4000)
  }

  override protected def afterEach(): Unit = {
    var file:File = new File("data.xml")
    var jaxbContext = JAXBContext.newInstance(classOf[SentimentIterationData])
    var jaxbMarshaller = jaxbContext.createMarshaller
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
    jaxbMarshaller.marshal(new SentimentIterationData, file)
  }


  it should "start main" in {
    val label = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(0)
    val chart = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(2).asInstanceOf[PieChart]

    val hbox = m.stage.getScene.getRoot.getChildrenUnmodifiable.get(1).asInstanceOf[HBox]

    val button0 = hbox.getChildrenUnmodifiable.get(0).asInstanceOf[Button]

    button0.fire()

    Thread.sleep(4000)

    chart.getData.get(0).getPieValue should be(1.0)
  }

}
