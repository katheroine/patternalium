import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistingConcreteHandler extends SnippetConvertingHandler {
  public SnippetPersistingConcreteHandler() {
    super(null);
  }

  public SnippetPersistingConcreteHandler(SnippetConvertingHandler successor) {
    super(successor);
  }

  public void handleConverting(String inputFilePath, String outputFilePath, String content) throws IOException {
    persist(content, outputFilePath);
  }

  public void persist(String fileContent, String snippetOutputFilePath) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(fileContent);
    outputFileWriter.close();
  }
}
