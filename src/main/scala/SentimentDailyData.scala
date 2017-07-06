import javax.xml.bind.annotation.{XmlElement, XmlRootElement}

@XmlRootElement
class SentimentDailyData() {
  var data: String = ""
  var sentiment: String = ""
  var mood: Int = 0

  def this(d: String, s: String, m: Int) {
    this()
    data = d
    sentiment = s
    mood = m
  }

  def getMood: Int = {
    mood
  }

  def getSentiment: String = {
    sentiment
  }

  def getData: String = {
    data
  }

  @XmlElement
  def setData(d: String) = {
    data = d
  }

  @XmlElement
  def setMood(m: Int): Unit = {
    mood = m
  }

  @XmlElement
  def setSentiment(s: String): Unit = {
    sentiment = s
  }
}