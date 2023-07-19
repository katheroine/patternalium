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

class SnippetConvertingDirector {
  private SnippetBuilder snippetBuilder;
  private String snippetPath;

  public SnippetConvertingDirector(SnippetBuilder snippetBuilder, String snippetPath) {
    this.snippetBuilder = snippetBuilder;
    this.snippetPath = snippetPath;
  }

  public void construct() throws ParserConfigurationException, SAXException, IOException {
    ArrayList<Node> snippetElements = extractXMLElements(snippetPath);

    for (int i = 0; i < snippetElements.size(); i++) {
      Node element = snippetElements.get(i);
      constructElement(element);
    }
  }

  private static ArrayList<Node> extractXMLElements(String filePath) throws ParserConfigurationException, SAXException, IOException {
    File file = new File(filePath);
    ArrayList<Node> fileElements = extractXMLFileElements(file);

    return fileElements;
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
    switch (element.getNodeName()) {
      case "paragraph":
        snippetBuilder.buildParagraph(element.getTextContent());
        break;
      case "list":
        snippetBuilder.buildList(element.getTextContent());
        break;
      case "source":
        snippetBuilder.buildSource(element.getTextContent());
        break;
    };
  }
}
