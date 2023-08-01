abstract class HTMLSnippetElementDecorator extends HTMLSnippetElementComponent {
  protected HTMLSnippetElementComponent snippetElement;

  public String getTag() {
    return snippetElement.getTag();
  }
}
