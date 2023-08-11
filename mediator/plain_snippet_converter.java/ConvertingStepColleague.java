import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

abstract class ConvertingStepColleague {
  private ConvertingMediator convertingMediator;

  public ConvertingStepColleague(ConvertingMediator convertingMediator) throws ParserConfigurationException, SAXException, IOException {
    this.convertingMediator = convertingMediator;
  }

  public void processed() throws ParserConfigurationException, SAXException, IOException {
    convertingMediator.stepColleagueFinished(this);
  }
}
