import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

interface SnippetConvertingCommand {
  public void execute() throws ParserConfigurationException, SAXException, IOException;
}
