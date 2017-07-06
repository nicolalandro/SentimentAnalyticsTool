

import java.io.File
import java.util.Date
import javafx.collections.FXCollections
import javafx.scene.chart.PieChart.Data
import javax.xml.bind.{JAXBContext, Marshaller}

import scalafx.event.ActionEvent
import scalafx.scene.chart.PieChart
import scalafxml.core.macros.sfxml

@sfxml
class HomePresenter(mPieChart: PieChart) {

  var jaxbContext = JAXBContext.newInstance(classOf[SentimentIterationData])
  var jaxbMarshaller = jaxbContext.createMarshaller
  var jaxbUnmarshaller = jaxbContext.createUnmarshaller
  var file:File = new File("data.xml")

  var sentimentData = readData()
  println(sentimentData.getDailyComments.size())
  println(sentimentData.getMoodOverview(1))

  mPieChart.setTitle("Iteration Mood")

  var mObservableList = FXCollections.observableArrayList[Data];
  mObservableList.add(new Data("0", sentimentData.getMoodOverview(0)))
  mObservableList.add(new Data("1", sentimentData.getMoodOverview(1)))
  mObservableList.add(new Data("2", sentimentData.getMoodOverview(2)))
  mObservableList.add(new Data("3", sentimentData.getMoodOverview(3)))
  mObservableList.add(new Data("4", sentimentData.getMoodOverview(4)))
  mPieChart.setData(mObservableList)

  def moodFace0(event: ActionEvent) = {
    addDataToPie(0)
  }

  def moodFace1(event: ActionEvent) = {
    addDataToPie(1)
  }

  def moodFace2(event: ActionEvent) = {
    addDataToPie(2)
  }

  def moodFace3(event: ActionEvent) = {
    addDataToPie(3)
  }

  def moodFace4(event: ActionEvent) = {
    addDataToPie(4)
  }

  def addDataToPie(x: Int) = {
    mObservableList.get(x).setPieValue(mObservableList.get(x).getPieValue + 1)
    val data = new SentimentDailyData(
                                        new Date(System.currentTimeMillis()).toString,
                                        "none",
                                        x)
    sentimentData.addData(data)

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
    jaxbMarshaller.marshal(sentimentData, file)

  }

  def readData(): SentimentIterationData = {
    (jaxbUnmarshaller.unmarshal(file)).asInstanceOf[SentimentIterationData];
//    new SentimentIterationData
  }

}
