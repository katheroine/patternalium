import java.util.ArrayList;

class HTMLSnippetNestingElement extends HTMLSnippetElement {
  private ArrayList<HTMLSnippetPlainElement> nestedElements;

  public HTMLSnippetNestingElement(String tag) {
    this.tag = tag;
    nestedElements = new ArrayList<HTMLSnippetPlainElement>();
  }

  public void accept(HTMLSnippetElementVisitor convertingVisitor) {
    convertingVisitor.visitSnippetNestingElement(this);
  }

  public ArrayList<HTMLSnippetPlainElement> getNestedElements() {
    return nestedElements;
  }

  public void add(HTMLSnippetPlainElement snippetElement) {
    nestedElements.add(snippetElement);
  }

  public void remove(HTMLSnippetPlainElement snippetElement) {
    nestedElements.remove(snippetElement);
  }
}
