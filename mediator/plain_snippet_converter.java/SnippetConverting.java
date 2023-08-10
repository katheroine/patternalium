import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConverting {
  private static String snippetInputFilePath = "./input/snippet.xml";
  private static String snippetOutputFilePath = "./output/snippet.html";

  // private ConvertingStepColleague extractingStep;
  // private ConvertingStepColleague persistanceStep;
  //
  // public static void createConvertingStepColleagues() {
  //   extractingStep = new SnippetElementsExtractingStepColleague(snippetInputFilePath, this);
  //   persistanceStep = new SnippetPersistanceStepColleague(snippetOutputFilePath, this);
  // }
  //
  // protected void stepColleagueFinished(ConvertingStepColleague convertingStep) throws ParserConfigurationException, SAXException, IOException {
  //   if (convertingStep == extractingStep) {
  //     ArrayList<String> elements = extractingStep.getExtractedElements();
  //     persistanceStep.persist(elements);
  //   }
  // }

  public static void main(String[] args) {
    // try {
      File snippetInputFile = new File(snippetInputFilePath);
      SnippetConvertingMediator convertingMediator = new SnippetConvertingMediator(snippetInputFile, snippetOutputFilePath);
      convertingMediator.runConversion();
      // convertingMediator.createConvertingStepColleagues();
      // FileManagerFacade fileManager = new FileManagerFacade();

      // extractingStep.extract();
      // SnippetElementsExtractor extractor = new SnippetElementsExtractor(snippetInputFile);
      // ArrayList<String> snippetElements = extractor.extract();
      //
      // String snippetContent = String.join("", snippetElements);
      // fileManager.writeToFileWithPath(snippetOutputFilePath, snippetContent);
    // } catch (ParserConfigurationException e) {
    //   System.out.println("An XML parser configuration error occurred.");
    //   e.printStackTrace();
    // } catch (SAXException e) {
    //   System.out.println("An XML parsing operation error occurred.");
    //   e.printStackTrace();
    // } catch (FileNotFoundException e) {
    //   System.out.println("A file cannot be found.");
    //   e.printStackTrace();
    // } catch (IOException e) {
    //   System.out.println("An input-output operation error occurred.");
    //   e.printStackTrace();
    // }
  }
}
