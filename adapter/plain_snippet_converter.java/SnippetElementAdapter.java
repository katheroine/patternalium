class SnippetElementAdapter implements SnippetElementTarget {
  HTMLSnippetElementAdaptee adaptee;

  public SnippetElementAdapter(HTMLSnippetElementAdaptee adaptee) {
    this.adaptee = adaptee;
  }

  public String getContent() {
    return adaptee.getHTMLContent();
  }
}
