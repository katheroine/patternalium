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

class SnippetElementsExtractingClient {
  private File snippetFile;
  private String extractedContent = "";

  public SnippetElementsExtractingClient(File snippetFile) {
    this.snippetFile = snippetFile;
  }

  public String extract() throws ParserConfigurationException, SAXException, IOException {
    ArrayList<Node> snippetElements = extractXMLFileElements(snippetFile);

    for (int i = 0; i < snippetElements.size(); i++) {
      Node element = snippetElements.get(i);
      constructElement(element);
    }

    return extractedContent;
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
    HTMLSnippetElementFlyweightFactory snippetElementFactory = new HTMLSnippetElementFlyweightFactory();
    String extractedElement = "";
    String snippetElementContentCore = "";

    switch (element.getNodeName()) {
      case "paragraph":
        snippetElementContentCore = refineText(element.getTextContent());
        extractedContent += snippetElementFactory.getSnippetElement("p").getHTMLContent(snippetElementContentCore);

        break;
      case "list":
        String[] listItems = splitText(element.getTextContent());
        String listItemContentCore = "";

        for (String listItem : listItems) {
          listItemContentCore = refineText(listItem);

          if (listItemContentCore == "")
            continue;

          snippetElementContentCore += snippetElementFactory.getSnippetElement("li").getHTMLContent(listItemContentCore);
        }

        extractedContent += snippetElementFactory.getSnippetElement("ul").getHTMLContent(snippetElementContentCore);

        break;
      case "source":
        snippetElementContentCore = refineText(element.getTextContent());
        extractedContent += snippetElementFactory.getSnippetElement("cite").getHTMLContent(snippetElementContentCore);

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
