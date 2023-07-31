import java.util.ArrayList;

class HTMLSnippetElementRealSubject implements HTMLSnippetElementSubject {
  private String tag;
  private String contentCore;
  private ArrayList<HTMLSnippetElementRealSubject> nestedElements;

  public HTMLSnippetElementRealSubject(String tag, String contentCore) {
    this.tag = tag;
    // this.contentCore = contentCore;
    this.nestedElements = new ArrayList<HTMLSnippetElementRealSubject>();
    establishContentCore(contentCore);
  }

  public String getHTMLContent() {
    String content = "";

    if (nestedElements.size() == 0) {
      content = contentCore;
    } else {
      content = getNestedElementsHTMLContent();
    }

    String HTMLContent = "<" + tag + ">" + content + "</" + tag + ">";

    return HTMLContent;
  }

  public void establishContentCore(String rawContentCore) {
    switch (tag) {
      case "p":
      case "cite":
      case "li":
        contentCore = refineText(rawContentCore);
        break;
      case "ul":
        String[] listItems = splitText(rawContentCore);
        String refinedList = "";

        for (String rawListItem : listItems) {
          String refinedListItem = refineText(rawListItem);

          if (refinedListItem == "")
            continue;

          HTMLSnippetElementRealSubject listItemElement = new HTMLSnippetElementRealSubject("li", refinedListItem);
          nestedElements.add(listItemElement);
        }

        break;
      }
  }

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(HTMLSnippetElementRealSubject nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
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
