import java.util.ArrayList
import java.util.Date
import javax.xml.bind.annotation.{XmlElement, XmlRootElement}

@XmlRootElement
class SentimentIterationData {
  var dailyComments: ArrayList[SentimentDailyData] = new ArrayList[SentimentDailyData]()
  var data: String = (new Date(System.currentTimeMillis)).toString

  var moodOverview: Array[Int] = Array(0, 0, 0, 0, 0);

  @XmlElement
  def setData(d:String): Unit ={
    data = d
  }

  @XmlElement
  def setDailyComments(d:ArrayList[SentimentDailyData]): Unit ={
    dailyComments = d
  }

  @XmlElement
  def setMoodOverview(v:Array[Int]): Unit ={
    moodOverview = v
  }

  def getData : String = {
    data
  }

  def getDailyComments : ArrayList[SentimentDailyData] = {
    dailyComments
  }

  def getMoodOverview: Array[Int] = {
    moodOverview
  }


  def addData(data: SentimentDailyData): Unit = {
    dailyComments add data
    moodOverview(data.getMood) = moodOverview(data.getMood) + 1
  }
}