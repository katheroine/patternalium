import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConverting {
  private static String snippetInputFilePath = "./input/snippet.xml";
  private static String snippetOutputFilePath = "./output/snippet.html";

  public static void main(String[] args) {
    try {
      File snippetInputFile = new File(snippetInputFilePath);
      SnippetElementsExtractorSubject snippetElementsExtractor = new SnippetElementsExtractorSubject(snippetInputFile);
      SnippetPersistanceObserver snippetPersistance = new SnippetPersistanceObserver(snippetOutputFilePath, snippetElementsExtractor);
      snippetElementsExtractor.extract();
    } catch (ParserConfigurationException e) {
      System.out.println("An XML parser configuration error occurred.");
      e.printStackTrace();
    } catch (SAXException e) {
      System.out.println("An XML parsing operation error occurred.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("An input-output operation error occurred.");
      e.printStackTrace();
    }
  }
}
