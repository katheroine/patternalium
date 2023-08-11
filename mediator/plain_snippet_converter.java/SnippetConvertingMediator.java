import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.FileNotFoundException;

class SnippetConvertingMediator extends ConvertingMediator {
  private File snippetInputFile;
  private String snippetOutputFilePath;

  private SnippetElementsExtractingStepColleague extractingStep;
  private SnippetPersistanceStepColleague persistanceStep;

  public SnippetConvertingMediator(File snippetInputFile, String snippetOutputFilePath) throws ParserConfigurationException, SAXException, IOException {
    this.snippetInputFile = snippetInputFile;
    this.snippetOutputFilePath = snippetOutputFilePath;
    createConvertingStepColleagues();
  }

  public void runConversion() throws ParserConfigurationException, SAXException, IOException {
      extractingStep.extract();
  }

  protected void createConvertingStepColleagues() throws ParserConfigurationException, SAXException, IOException {
    extractingStep = new SnippetElementsExtractingStepColleague(snippetInputFile, this);
    persistanceStep = new SnippetPersistanceStepColleague(snippetOutputFilePath, this);
  }

  protected void stepColleagueFinished(ConvertingStepColleague convertingStep) throws ParserConfigurationException, SAXException, IOException {
    if (convertingStep == extractingStep) {
      ArrayList<String> elements = extractingStep.getExtractedElements();
        persistanceStep.persist(elements);
    }
  }
}
