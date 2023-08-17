import java.util.ArrayList;

class HTMLSnippetNestingElement extends HTMLSnippetElement {
  private ArrayList<HTMLSnippetPlainElement> nestedElements;

  public HTMLSnippetNestingElement(String tag) {
    this.tag = tag;
    nestedElements = new ArrayList<HTMLSnippetPlainElement>();
  }

  public void add(HTMLSnippetPlainElement snippetElement) {
    nestedElements.add(snippetElement);
  }

  public void remove(HTMLSnippetPlainElement snippetElement) {
    nestedElements.remove(snippetElement);
  }

  public String getContent() {
    String coreContent = getNestedElementsContent();
    String content = "<" + tag + ">" + coreContent + "</" + tag + ">";

    return content;
  }

  private String getNestedElementsContent() {
    String nestedElementsContent = "";

    for(HTMLSnippetPlainElement nestedElement : nestedElements) {
      nestedElementsContent += nestedElement.getContent();
    }

    return nestedElementsContent;
  }
}
