class SnippetElementAdapter implements SnippetElementTarget {
  HTMLSnippetElementAdaptee adaptee;
  private String elementType;
  private String content;
  private SnippetElementTarget[] nestedElements;

  public SnippetElementAdapter(HTMLSnippetElementAdaptee adaptee) {
    this.adaptee = adaptee;
  }

  // public SnippetElementAdapter(String elementType, String content)  {
  //   this.elementType = elementType;
  //   this.content = content;
  // }
  //
  // public SnippetElementAdapter(String elementType, SnippetElementTarget[] nestedElements) {
  //   this.elementType = elementType;
  //   this.nestedElements = nestedElements;
  // }

  public String getContent() {
    return adaptee.getHTMLContent();
  }
}
