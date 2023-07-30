class SnippetElementRefinedAbstraction extends SnippetElementAbstraction {
  public SnippetElementRefinedAbstraction(SnippetElementImplementator implementator) {
    super(implementator);
  }

  public String getContent() {
    return implementator.getHTMLContent();
  }
}
