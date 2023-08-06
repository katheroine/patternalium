import java.io.FileWriter;
import java.io.IOException;

class SnippetPersistingReceiver {
  private String snippetOutputFilePath;

  public SnippetPersistingReceiver(String snippetOutputFilePath) {
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void action(String content) throws IOException {
    persist(content, snippetOutputFilePath);
  }

  public void persist(String fileContent, String snippetOutputFilePath) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(fileContent);
    outputFileWriter.close();
  }
}
