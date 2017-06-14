import scalafx.event.ActionEvent
import scalafx.scene.chart.AreaChart
import scalafxml.core.macros.sfxml

@sfxml
class HomePresenter(mAreaChart:AreaChart[Number,Number]) {

  mAreaChart.setTitle("Iteration Mood")

  def moodFace(event: ActionEvent) = {
    println("yeeeee")
  }
}
