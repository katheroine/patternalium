import java.util.ArrayList;

class HTMLSnippetElementConcreteImplementor extends SnippetElementImplementor {
  public HTMLSnippetElementConcreteImplementor(String tag, String contentCore) {
    super(tag, contentCore);
  }

  public HTMLSnippetElementConcreteImplementor(String tag, ArrayList<SnippetElementImplementor> nestedElements) {
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

    for(SnippetElementImplementor nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
  }
}
