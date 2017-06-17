

import java.io.{BufferedWriter, File, FileWriter}
import javafx.collections.FXCollections
import javafx.scene.chart.PieChart.Data

import com.lambdaworks.jacks.JacksMapper

import scala.io.Source
import scalafx.event.ActionEvent
import scalafx.scene.chart.PieChart
import scalafxml.core.macros.sfxml

@sfxml
class HomePresenter(mPieChart: PieChart) {

  var vector = readData()

  mPieChart.setTitle("Iteration Mood")

  var mObservableList = FXCollections.observableArrayList[Data];
  mObservableList.add(new Data("0", vector(0)))
  mObservableList.add(new Data("1", vector(1)))
  mObservableList.add(new Data("2", vector(2)))
  mObservableList.add(new Data("3", vector(3)))
  mObservableList.add(new Data("4", vector(4)))
  mPieChart.setData(mObservableList)

  def moodFace0(event: ActionEvent) = {
    addDataToPie(0, 1)
  }

  def moodFace1(event: ActionEvent) = {
    addDataToPie(1, 1)
  }

  def moodFace2(event: ActionEvent) = {
    addDataToPie(2, 1)
  }

  def moodFace3(event: ActionEvent) = {
    addDataToPie(3, 1)
  }

  def moodFace4(event: ActionEvent) = {
    addDataToPie(4, 1)
  }

  def addDataToPie(x: Int, y: Int) = {
    mObservableList.get(x).setPieValue(mObservableList.get(x).getPieValue + y)
    vector = addToVector(x)
    val json = JacksMapper.writeValueAsString(vector)
    println(json)
    val file = new File("data.json")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(json.toString)
    bw.close()
  }

  def addToVector(x: Int) = x match {
    case 0 => Vector(vector(0) + 1, vector(1), vector(2), vector(3), vector(4))
    case 1 => Vector(vector(0), vector(1) + 1, vector(2), vector(3), vector(4))
    case 2 => Vector(vector(0), vector(1), vector(2) + 1, vector(3), vector(4))
    case 3 => Vector(vector(0), vector(1), vector(2), vector(3) + 1, vector(4))
    case 4 => Vector(vector(0), vector(1), vector(2), vector(3), vector(4) + 1)
  }

  def readData(): Seq[Int] = {
    var string = ""
    val filename = "data.json"
    for (line <- Source.fromFile(filename).getLines) {
      string = string + line
    }
    return JacksMapper.readValue[List[Int]](string)
  }

}
