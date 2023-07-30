class SnippetElementRefinedAbstraction extends SnippetElementAbstraction {
  public SnippetElementRefinedAbstraction(SnippetElementImplementor implementator) {
    super(implementator);
  }

  public String getContent() {
    return implementator.getHTMLContent();
  }
}
