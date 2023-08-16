abstract class HTMLSnippetElement {
  protected String tag;

  abstract public void accept(HTMLSnippetElementVisitor convertingVisitor);

  public String getTag() {
    return tag;
  }
}
