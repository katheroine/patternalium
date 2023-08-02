import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistanceClient {
  private static String snippetOutputFilePath;

  public SnippetPersistanceClient(String snippetOutputFilePath) {
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void persist(ArrayList<HTMLSnippetElementComponent> snippetElements) throws IOException  {
      String fileContent = "";

      for (HTMLSnippetElementComponent snippetElement : snippetElements) {
        fileContent += snippetElement.getHTMLContent();
      }

      writeToOutputFile(fileContent);
  }

  private static void writeToOutputFile(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }
}
