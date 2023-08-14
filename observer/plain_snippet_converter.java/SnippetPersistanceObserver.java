import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistanceObserver extends SnippetConvertingObserver {
  private static String snippetOutputFilePath;
  private ArrayList<String> snippetElements;
  protected SnippetElementsExtractorSubject convertingSubject;

  public SnippetPersistanceObserver(String snippetOutputFilePath, SnippetElementsExtractorSubject convertingSubject) {
    this.convertingSubject = convertingSubject;
    this.convertingSubject.attach(this);
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void update() throws IOException {
    snippetElements = convertingSubject.getState();
    persist();
  }

  public void persist() throws IOException  {
      String fileContent = "";

      for (String snippetElement : snippetElements) {
        fileContent += snippetElement;
      }

      writeToOutputFile(fileContent);
  }

  private static void writeToOutputFile(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }
}
