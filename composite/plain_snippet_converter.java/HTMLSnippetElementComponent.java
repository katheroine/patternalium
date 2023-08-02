abstract class HTMLSnippetElementComponent {
  protected String tag;

  abstract public void add(HTMLSnippetElementComponent snippetElement);
  abstract public void remove(HTMLSnippetElementComponent snippetElement);
  abstract public String getHTMLContent();
}
