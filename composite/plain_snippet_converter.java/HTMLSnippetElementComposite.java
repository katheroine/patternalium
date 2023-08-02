import java.util.ArrayList;

class HTMLSnippetElementComposite extends HTMLSnippetElementComponent {
  private ArrayList<HTMLSnippetElementComponent> nestedElements;

  public HTMLSnippetElementComposite(String tag) {
    this.tag = tag;
    nestedElements = new ArrayList<HTMLSnippetElementComponent>();
  }

  public void add(HTMLSnippetElementComponent snippetElement) {
    nestedElements.add(snippetElement);
  }

  public void remove(HTMLSnippetElementComponent snippetElement) {
    nestedElements.remove(snippetElement);
  }

  public String getHTMLContent() {
    String content = getNestedElementsHTMLContent();
    String HTMLContent = "<" + tag + ">" + content + "</" + tag + ">";

    return HTMLContent;
  }

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(HTMLSnippetElementComponent nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
  }
}
