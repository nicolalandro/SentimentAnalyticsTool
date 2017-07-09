import java.awt.Robot
import java.awt.event.InputEvent
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.stage.Stage

import javafx.scene.layout.HBox

trait ScalaFXMatchers {
  val bot = new Robot()
  var stage: Stage = null

  def setStage(s: Stage) = {
    stage = s
  }

  def extractNode(id: String): Node = {
    val nodeList = _getAllNodeList
    nodeList.forall(n => {val x = println(n.getId);true})
    val listId = nodeList.filter((n) => n.getId() != null && n.getId.equals(id))

    print(listId.head.getId)

    if(listId.size==1) listId.head
    else null
  }

  def clickOn(id: String): Unit = {
    clickOn(extractNode(id))
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

  def _getAllNodeList(): List[Node] = {
    _getListFromObservableListOfNode(stage.getScene.getRoot.getChildrenUnmodifiable).flatMap((n)=> {
      if(n.isInstanceOf[HBox])
        n::_getListFromObservableListOfNode((n.asInstanceOf[HBox]).getChildrenUnmodifiable)
      else List(n)
    })
  }

  def _getListFromObservableListOfNode(list:ObservableList[Node]): List[Node] ={
    (for(i: Int <- (0 to list.size() - 1)) yield list.get(i)).toList
  }

}
