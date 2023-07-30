abstract class SnippetElementAbstraction {
  protected SnippetElementImplementator implementator;

  public SnippetElementAbstraction(SnippetElementImplementator implementator) {
    this.implementator = implementator;
  }

  abstract public String getContent();
}
