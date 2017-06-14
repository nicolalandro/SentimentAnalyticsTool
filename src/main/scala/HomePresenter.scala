import scalafx.event.ActionEvent
import scalafx.scene.chart.AreaChart
import scalafxml.core.macros.sfxml

@sfxml
class HomePresenter(mAreaChart:AreaChart[Number,Number]) {

  mAreaChart.setTitle("Iteration Mood")

  def moodFace0(event: ActionEvent) = {
    println("yeeeee")
  }
  def moodFace1(event: ActionEvent) = {
    println("yeeeee")
  }
  def moodFace2(event: ActionEvent) = {
    println("yeeeee")
  }
  def moodFace3(event: ActionEvent) = {
    println("yeeeee")
  }
  def moodFace4(event: ActionEvent) = {
    println("yeeeee")
  }
}
