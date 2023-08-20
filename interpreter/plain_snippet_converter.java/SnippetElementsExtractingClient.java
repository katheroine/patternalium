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
import java.util.Scanner;

class SnippetElementsExtractingClient {
  private File snippetFile;
  private ArrayList<String> extractedElements;

  public SnippetElementsExtractingClient(File snippetFile) {
    this.snippetFile = snippetFile;
    extractedElements = new ArrayList<String>();
  }

  public ArrayList<String> extract() throws ParserConfigurationException, SAXException, IOException, Exception {
    ArrayList<Node> snippetElements = extractXMLFileElements(snippetFile);

    for (int i = 0; i < snippetElements.size(); i++) {
      Node element = snippetElements.get(i);
      constructElement(element);
    }

    return extractedElements;
  }

  private static ArrayList<Node> extractXMLFileElements(File documentFile) throws ParserConfigurationException, SAXException, IOException, Exception {
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

  private static ArrayList<Node> extractXMLDocumentElements(Document document) throws Exception {
    ArrayList<Node> resultDocumentElements = new ArrayList<Node>();
    ArrayList<XMLSnippetElementAbstractExpression> nestedElementExpressions = new ArrayList<XMLSnippetElementAbstractExpression>();
    NodeList documentElements = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < documentElements.getLength(); i++) {
      Node element = documentElements.item(i);

      if (element.getNodeName() == "#text") continue;

      resultDocumentElements.add(element);

      XMLSnippetElementTerminalExpression nestedElementExpression = new XMLSnippetElementTerminalExpression(element);
      nestedElementExpressions.add(nestedElementExpression);
    }

    XMLSnippetElementNonterminalExpression elementExpression = new XMLSnippetElementNonterminalExpression(document.getDocumentElement(), nestedElementExpressions);
    XMLSnippetElementContext context = new XMLSnippetElementContext("snippet", new String[] {"paragraph", "list", "source"});
    boolean snippetIsValid = elementExpression.interpret(context);

    if (! snippetIsValid) {
      throw new Exception("XML Snippet is invalid.");
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
}
