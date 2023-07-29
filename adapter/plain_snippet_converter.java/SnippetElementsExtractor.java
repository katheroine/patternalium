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

class SnippetElementsExtractor {
  // private SnippetElementCreator snippetElementCreator;
  private File snippetFile;
  // private ArrayList<String> extractedElements;
  private ArrayList<SnippetElementTarget> extractedElements;

  public SnippetElementsExtractor(File snippetFile) {
    // this.snippetElementCreator = snippetElementCreator;
    this.snippetFile = snippetFile;
    extractedElements = new ArrayList<SnippetElementTarget>();
  }

  public ArrayList<SnippetElementTarget> extract() throws ParserConfigurationException, SAXException, IOException {
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
    // ArrayList<SnippetElementAdapter> snippetElements = new ArrayList<SnippetElementAdapter>();

    switch (element.getNodeName()) {
      case "paragraph":
        // snippetBuilder.buildParagraph(element.getTextContent());
        HTMLSnippetElementAdaptee HTMLSnippetParagraphElement = new HTMLSnippetElementAdaptee("p", refineText(element.getTextContent()));
        SnippetElementAdapter snippetParagraphElement = new SnippetElementAdapter(HTMLSnippetParagraphElement);
        extractedElements.add(snippetParagraphElement);

        break;
      case "list":
        // snippetBuilder.buildList(element.getTextContent());
        String[] listRawItems = splitText(element.getTextContent());
        ArrayList<HTMLSnippetElementAdaptee> listItems = new ArrayList<HTMLSnippetElementAdaptee>();

        for (String rawListItem : listRawItems) {
          String refinedListItem = refineText(rawListItem);

          if (refinedListItem == "")
            continue;

          // list += "<li>" + refinedListItem + "</li>";
          HTMLSnippetElementAdaptee HTMLSnippetListItemElement = new HTMLSnippetElementAdaptee("li", refinedListItem);
          listItems.add(HTMLSnippetListItemElement);
        }

        // HTMLSnippetElementAdaptee HTMLSnippetListItemElement = new HTMLSnippetElementAdaptee("li", "nevermind");
        // listItems.add(HTMLSnippetListItemElement);

        HTMLSnippetElementAdaptee HTMLSnippetListElement = new HTMLSnippetElementAdaptee("ul", listItems);
        SnippetElementAdapter snippetListElement = new SnippetElementAdapter(HTMLSnippetListElement);
        extractedElements.add(snippetListElement);

        break;
      case "source":
        // snippetBuilder.buildSource(element.getTextContent());
        HTMLSnippetElementAdaptee HTMLSnippetSourceElement = new HTMLSnippetElementAdaptee("cite", refineText(element.getTextContent()));
        SnippetElementAdapter snippetSourceElement = new SnippetElementAdapter(HTMLSnippetSourceElement);
        extractedElements.add(snippetSourceElement);

        break;
    };

    // String extractedElementContent = snippetElementCreator.factoryMethod().getContent();

    // for (SnippetElementAdapter snippetElement : snippetElements) {
    //   extractedElements.add(snippetElement.getContent());
    // }
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
