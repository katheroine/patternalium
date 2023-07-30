import java.util.ArrayList;

class HTMLSnippetElementConcreteImplementator extends SnippetElementImplementator {
  public HTMLSnippetElementConcreteImplementator(String tag, String contentCore) {
    super(tag, contentCore);
  }

  public HTMLSnippetElementConcreteImplementator(String tag, ArrayList<SnippetElementImplementator> nestedElements) {
    super(tag, nestedElements);
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

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(SnippetElementImplementator nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
  }
}
