import java.util.ArrayList;

class HTMLSnippetNestingElementOriginator extends HTMLSnippetElement {
  private ArrayList<HTMLSnippetElement> nestedElements;

  public HTMLSnippetNestingElementOriginator(String tag) {
    this.tag = tag;
    nestedElements = new ArrayList<HTMLSnippetElement>();
  }

  public HTMLSnippetElementMemento saveState() {
    return new HTMLSnippetElementMemento(nestedElements);
  }

  public void restoreState(HTMLSnippetElementMemento memento) {
    nestedElements = memento.getState();
  }

  public void addNestedElement(HTMLSnippetElement snippetElement) {
    nestedElements.add(snippetElement);
  }

  public void removeNestedElement(HTMLSnippetElement snippetElement) {
    nestedElements.remove(snippetElement);
  }

  public String getHTMLContent() {
    String content = getNestedElementsHTMLContent();
    String HTMLContent = "<" + tag + ">" + content + "</" + tag + ">";

    return HTMLContent;
  }

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(HTMLSnippetElement nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
  }
}
