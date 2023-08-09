import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistance {
  private static String snippetOutputFilePath;

  public SnippetPersistance(String snippetOutputFilePath) {
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void persist(ArrayList<HTMLSnippetElement> snippetElements) throws IOException  {
      String fileContent = "";

      for (HTMLSnippetElement snippetElement : snippetElements) {
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
