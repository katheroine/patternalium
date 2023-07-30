class SnippetElementAbstraction {
  protected SnippetElementImplementator implementator;

  public SnippetElementAbstraction(SnippetElementImplementator implementator) {
    this.implementator = implementator;
  }

  public String getContent() {
    return implementator.getHTMLContent();
  }
}
