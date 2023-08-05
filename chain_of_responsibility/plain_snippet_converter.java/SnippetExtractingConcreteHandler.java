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

class SnippetExtractingConcreteHandler extends SnippetConvertingHandler {
  private File snippetFile;
  private ArrayList<String> extractedElements;

  public SnippetExtractingConcreteHandler(SnippetConvertingHandler successor) {//}, File snippetFile) {
    this.successor = successor;
    // super(successor);
    // this.snippetFile = snippetFile;
    extractedElements = new ArrayList<String>();
  }

  public void handleConverting(String inputFilePath, String outputFilePath, String content) throws ParserConfigurationException, SAXException, IOException {
    if (successor != null) {
      snippetFile = new File(inputFilePath);
      extract();
      String extractedContent = String.join("", extractedElements);

      successor.handleConverting(inputFilePath, outputFilePath, extractedContent);
    }
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
    HTMLSnippetConverter snippetConverter = new HTMLSnippetConverter();
    String extractedElement = "";

    switch (element.getNodeName()) {
      case "paragraph":
        extractedElement = snippetConverter.convertParagraph(element.getTextContent());
        extractedElements.add(extractedElement);
        break;
      case "list":
        extractedElement = snippetConverter.convertList(element.getTextContent());
        extractedElements.add(extractedElement);
        break;
      case "source":
        extractedElement = snippetConverter.convertSource(element.getTextContent());
        extractedElements.add(extractedElement);
        break;
    };
  }

  static String refineText(String text) {
    return text
      .replaceAll("\\r\\n|\\r|\\n", "")
      .replaceAll("( )+", " ")
      .trim();
  }

  static String[] splitText(String text) {
    return text.split("\\r?\\n|\\r");
  }
}
