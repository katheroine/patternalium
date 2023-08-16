class HTMLSnippetPlainElement extends HTMLSnippetElement {
  private String contentCore;

  public HTMLSnippetPlainElement(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  public void accept(HTMLSnippetElementVisitor convertingVisitor) {
    convertingVisitor.visitSnippetPlainElement(this);
  }

  public String getContentCore() {
    return contentCore;
  }
}
