import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConvertingClient {
  public static void main(String[] args) {
    try {
      String inputPath = "./input/snippet.xml";
      HTMLSnippetBuilder builder = new HTMLSnippetBuilder();
      SnippetConvertingDirector director = new SnippetConvertingDirector(builder, inputPath);
      director.construct();
      String result = builder.getResult();
      System.out.println(result);
    } catch (ParserConfigurationException e) {
      System.out.println("An XML parser configuration error occurred.");
      e.printStackTrace();
    } catch (SAXException e) {
      System.out.println("An XML parsing operation error occurred.");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("A file cannot be found.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("An input-output operation error occurred.");
      e.printStackTrace();
    }
  }
}
