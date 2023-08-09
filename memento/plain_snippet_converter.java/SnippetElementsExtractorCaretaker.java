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

class SnippetElementsExtractorCaretaker {
  private File snippetFile;
  private ArrayList<HTMLSnippetElement> extractedElements;

  public SnippetElementsExtractorCaretaker(File snippetFile) {
    this.snippetFile = snippetFile;
    extractedElements = new ArrayList<HTMLSnippetElement>();
  }

  public ArrayList<HTMLSnippetElement> extract() throws ParserConfigurationException, SAXException, IOException {
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

    switch (element.getNodeName()) {
      case "paragraph":
        String refinedParagraph = refineText(element.getTextContent());
        HTMLSnippetPlainElement HTMLSnippetParagraphElement = new HTMLSnippetPlainElement("p", refinedParagraph);
        extractedElements.add(HTMLSnippetParagraphElement);

        break;
      case "list":
        String[] listRawItems = splitText(element.getTextContent());
        HTMLSnippetNestingElementOriginator HTMLSnippetListElement = new HTMLSnippetNestingElementOriginator("ul");
        HTMLSnippetElementMemento listElementMemento = HTMLSnippetListElement.saveState();

        for (String rawListItem : listRawItems) {
          String refinedListItem = refineText(rawListItem);

          HTMLSnippetPlainElement HTMLSnippetListItemElement = new HTMLSnippetPlainElement("li", refinedListItem);
          HTMLSnippetListElement.addNestedElement(HTMLSnippetListItemElement);

          if (refinedListItem == "")
            HTMLSnippetListElement.restoreState(listElementMemento);

          listElementMemento = HTMLSnippetListElement.saveState();
        }

        extractedElements.add(HTMLSnippetListElement);

        break;
      case "source":
        String refinedSource = refineText(element.getTextContent());
        HTMLSnippetPlainElement HTMLSnippetCiteElement = new HTMLSnippetPlainElement("cite", refinedSource);
        extractedElements.add(HTMLSnippetCiteElement);

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
