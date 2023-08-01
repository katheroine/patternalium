import java.util.ArrayList;

class HTMLSnippetNestingElementConcreteDecorator extends HTMLSnippetElementDecorator {
  private ArrayList<HTMLSnippetElementComponent> nestedElements;

  public HTMLSnippetNestingElementConcreteDecorator(HTMLSnippetElementComponent snippetElement, ArrayList<HTMLSnippetElementComponent> nestedElements) {
    this.snippetElement = snippetElement;
    this.nestedElements = nestedElements;
  }

  public String getHTMLContent() {
    String content = getNestedElementsHTMLContent();
    String HTMLContent = "<" + getTag() + ">" + content + "</" + getTag() + ">";

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
