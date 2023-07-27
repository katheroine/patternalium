import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileNotFoundException;
import org.w3c.dom.NodeList;
// import java.util.HashMap;

class SnippetElementsExtractor {
  // private HTMLSnippetElementSynthesizerSingleton snippetElementSynthesizer;
  // private Map<String, SnippetElementPrototype> snippetElementPrototypes;
  SnippetElementPrototype snippetElementPrototype;
  private File snippetFile;
  private ArrayList<String> extractedElements;

  public SnippetElementsExtractor(File snippetFile) {
    // this.snippetElementSynthesizer = HTMLSnippetElementSynthesizerSingleton.getInstance();
    this.snippetFile = snippetFile;
    extractedElements = new ArrayList<String>();
  }

  public ArrayList<String> extract() throws ParserConfigurationException, SAXException, IOException {
    ArrayList<Node> snippetElements = extractXMLFileElements(snippetFile);

    for (int i = 0; i < snippetElements.size(); i++) {
      Node element = snippetElements.get(i);
      constructElement(element);
    }

    return extractedElements;
  }

  private static ArrayList<Node> extractXMLFileElements(File documentFile) throws ParserConfigurationException, SAXException, IOException {
    Document parsedDocument = parseXMLDocument(documentFile);
    ArrayList<Node> documentElements = extractXMLDocumentElements(parsedDocument);

    return documentElements;
  }

  private static Document parseXMLDocument(File documentFile) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilder documentBuilder = provideXMLDocumentBuilder();

    Document parsedDocument = documentBuilder.parse(documentFile);
    parsedDocument.getDocumentElement().normalize();

    return parsedDocument;
  }

  private static DocumentBuilder provideXMLDocumentBuilder() throws ParserConfigurationException {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

      return documentBuilder;
  }

  private static ArrayList<Node> extractXMLDocumentElements(Document document) {
    ArrayList<Node> resultDocumentElements = new ArrayList<Node>();
    NodeList documentElements = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < documentElements.getLength(); i++) {
      Node element = documentElements.item(i);

      if (element.getNodeName() == "#text") continue;

      resultDocumentElements.add(element);
    }

    return resultDocumentElements;
  }

  private void constructElement(Node element) {
    // snippetElementCreator.setElementTypeOperation(element.getNodeName());
    // snippetElementCreator.setElementCoreContentOperation(element.getTextContent());
    if (snippetElementPrototype == null) {
      snippetElementPrototype = new HTMLSnippetElementPrototype(element.getNodeName(), element.getTextContent());
    }

    SnippetElementPrototype currentSnippetElementPrototype = snippetElementPrototype.clone();
    currentSnippetElementPrototype.setElementType(element.getNodeName());
    currentSnippetElementPrototype.setContentCore(element.getTextContent());

    // String extractedElementContent = snippetElementSynthesizer.synthesize(element.getNodeName(), element.getTextContent());
    String extractedElementContent = currentSnippetElementPrototype.getContent();

    extractedElements.add(extractedElementContent);
  }
}