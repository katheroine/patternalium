import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

class SnippetConvertingHandler {
  protected SnippetConvertingHandler successor;

  // public SnippetConvertingHandler(SnippetConvertingHandler successor) {
  //   this.successor = successor;
  // }

  public void handleConverting(String inputFilePath, String outputFilePath, String content) throws ParserConfigurationException, SAXException, IOException {
    if (successor != null) {
      successor.handleConverting(inputFilePath, outputFilePath, content);
    }
  }
}
