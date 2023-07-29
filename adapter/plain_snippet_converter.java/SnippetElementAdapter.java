class SnippetElementAdapter implements SnippetElementTarget {
  HTMLSnippetElementAdaptee adaptee;
  private String elementType;
  private String content;
  private SnippetElementTarget[] nestedElements;

  public SnippetElementAdapter(HTMLSnippetElementAdaptee adaptee) {
    this.adaptee = adaptee;
  }

  public String getContent() {
    return adaptee.getHTMLContent();
  }
}
