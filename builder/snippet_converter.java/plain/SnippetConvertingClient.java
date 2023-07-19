import java.io.File;
import java.io.FileWriter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConvertingClient {
  private static String snippetInputFilePath = "./input/snippet.xml";
  private static String snippetOutputFilePath = "./output/snippet.html";

  private static void writeOutput(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }

  public static void main(String[] args) {
    try {
      File snippetInputFile = new File(snippetInputFilePath);
      HTMLSnippetBuilder builder = new HTMLSnippetBuilder();
      SnippetConvertingDirector director = new SnippetConvertingDirector(builder, snippetInputFile);
      director.construct();
      String result = builder.getResult();
      writeOutput(result);
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
