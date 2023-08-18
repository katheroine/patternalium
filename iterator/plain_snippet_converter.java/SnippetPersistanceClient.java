import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistanceClient {
  private static String snippetOutputFilePath;

  public SnippetPersistanceClient(String snippetOutputFilePath) {
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void persist(SnippetElementsAggregateList snippetElements) throws IOException  {
      String fileContent = "";
      SnippetElementsListIterator extractedElementsIterator = new SnippetElementsListIterator(snippetElements);

      for (extractedElementsIterator.first(); extractedElementsIterator.isDone() != true; extractedElementsIterator.next()) {
        fileContent += extractedElementsIterator.currentItem().getContent();
      }

      writeToOutputFile(fileContent);
  }

  private static void writeToOutputFile(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }
}
