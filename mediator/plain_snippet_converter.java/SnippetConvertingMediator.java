import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConvertingMediator extends ConvertingMediator {
  // private static String snippetInputFilePath = "./input/snippet.xml";
  private File snippetInputFile;
  private String snippetOutputFilePath;

  private SnippetElementsExtractingStepColleague extractingStep;
  private SnippetPersistanceStepColleague persistanceStep;

  public SnippetConvertingMediator(File snippetInputFile, String snippetOutputFilePath) {
    this.snippetInputFile = snippetInputFile;
    this.snippetOutputFilePath = snippetOutputFilePath;
    createConvertingStepColleagues();
  }

  public void runConversion() {
    try {
      extractingStep.extract();
    } catch (Exception e) {

    }
  }

  protected void createConvertingStepColleagues() {
    extractingStep = new SnippetElementsExtractingStepColleague(snippetInputFile, this);
    persistanceStep = new SnippetPersistanceStepColleague(snippetOutputFilePath, this);
  }

  protected void stepColleagueFinished(ConvertingStepColleague convertingStep) {//throws ParserConfigurationException, SAXException, IOException {
    if (convertingStep == extractingStep) {
      ArrayList<String> elements = extractingStep.getExtractedElements();
      try {
        persistanceStep.persist(elements);
      } catch (Exception e) {

      }
    }
  }

  // public static void main(String[] args) {
  //   try {
  //     createConvertingStepColleagues();
  //     FileManagerFacade fileManager = new FileManagerFacade();
  //
  //     File snippetInputFile = fileManager.createFileWithPath(snippetInputFilePath);
  //     extractingStep.extract();
  //     // SnippetElementsExtractor extractor = new SnippetElementsExtractor(snippetInputFile);
  //     // ArrayList<String> snippetElements = extractor.extract();
  //     //
  //     // String snippetContent = String.join("", snippetElements);
  //     // fileManager.writeToFileWithPath(snippetOutputFilePath, snippetContent);
  //   } catch (ParserConfigurationException e) {
  //     System.out.println("An XML parser configuration error occurred.");
  //     e.printStackTrace();
  //   } catch (SAXException e) {
  //     System.out.println("An XML parsing operation error occurred.");
  //     e.printStackTrace();
  //   } catch (FileNotFoundException e) {
  //     System.out.println("A file cannot be found.");
  //     e.printStackTrace();
  //   } catch (IOException e) {
  //     System.out.println("An input-output operation error occurred.");
  //     e.printStackTrace();
  //   }
  // }
}
