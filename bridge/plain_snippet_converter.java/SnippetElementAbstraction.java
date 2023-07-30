abstract class SnippetElementAbstraction {
  protected SnippetElementImplementor implementator;

  public SnippetElementAbstraction(SnippetElementImplementor implementator) {
    this.implementator = implementator;
  }

  abstract public String getContent();
}
