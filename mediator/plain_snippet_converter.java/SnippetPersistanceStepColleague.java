import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class SnippetPersistanceStepColleague extends ConvertingStepColleague {
  private static String snippetOutputFilePath;

  public SnippetPersistanceStepColleague(String snippetOutputFilePath, ConvertingMediator convertingMediator) {
    super(convertingMediator);
    this.snippetOutputFilePath = snippetOutputFilePath;
  }

  public void persist(ArrayList<String> snippetElements) throws IOException  {
      String fileContent = "";

      for (String snippetElement : snippetElements) {
        fileContent += snippetElement;
      }

      writeToOutputFile(fileContent);

      processed();
  }

  private static void writeToOutputFile(String outputContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(snippetOutputFilePath);
    outputFileWriter.write(outputContent);
    outputFileWriter.close();
  }
}
