

import javafx.collections.FXCollections
import javafx.scene.chart.PieChart.Data

import scalafx.event.ActionEvent
import scalafx.scene.chart.PieChart
import scalafxml.core.macros.sfxml

@sfxml
class HomePresenter(mPieChart:PieChart) {

  mPieChart.setTitle("Iteration Mood")

  var mObservableList = FXCollections.observableArrayList[Data];
  mObservableList.add(new Data("0",0))
  mObservableList.add(new Data("1",0))
  mObservableList.add(new Data("2",0))
  mObservableList.add(new Data("3",0))
  mObservableList.add(new Data("4",0))
  mPieChart.setData(mObservableList)

  def moodFace0(event: ActionEvent) = {
    addDataToPie(0,1)
  }
  def moodFace1(event: ActionEvent) = {
    addDataToPie(1,1)
  }
  def moodFace2(event: ActionEvent) = {
    addDataToPie(2,1)
  }
  def moodFace3(event: ActionEvent) = {
    addDataToPie(3,1)
  }
  def moodFace4(event: ActionEvent) = {
    addDataToPie(4,1)
  }

  def addDataToPie(x:Int, y:Int) ={
    mObservableList.get(x).setPieValue(mObservableList.get(x).getPieValue+1)
  }
}
