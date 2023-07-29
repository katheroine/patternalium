// import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
// import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;

class SnippetPersistance {
  // private static String snippetInputFilePath;
  private static String snippetOutputFilePath;
  private static SnippetElementsExtractor extractor;

  public SnippetPersistance(String snippetOutputFilePath) {
    // this.snippetInputFilePath = snippetInputFilePath;
    this.snippetOutputFilePath = snippetOutputFilePath;
    // this.extractor = extractor;
  }

  // private File snippetInputFile;
  // private ArrayList<String> extractedElements;
  //
  // public ArrayList<SnippetElementTarget> load() throws ParserConfigurationException, SAXException, IOException {
  //   ArrayList<SnippetElementTarget> extractedElements = extractor.extract();
  //
  //   return extractedElements;
  // }

  public void persist(ArrayList<SnippetElementTarget> snippetElements) throws IOException  {
      String fileContent = "";

      for (int i = 0; i < snippetElements.size(); i++) {
        fileContent += snippetElements.get(i).getContent();
      }

      writeToOutputFile(fileContent);
  }

  private static void writeToOutputFile(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }
}
