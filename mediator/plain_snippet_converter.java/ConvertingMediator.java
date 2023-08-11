import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

abstract class ConvertingMediator {
  abstract protected void createConvertingStepColleagues() throws ParserConfigurationException, SAXException, IOException;
  abstract protected void stepColleagueFinished(ConvertingStepColleague convertingStep) throws ParserConfigurationException, SAXException, IOException;
}
