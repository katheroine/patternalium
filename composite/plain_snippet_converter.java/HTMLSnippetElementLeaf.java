class HTMLSnippetElementLeaf extends HTMLSnippetElementComponent {
  private String contentCore;

  public HTMLSnippetElementLeaf(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  public void add(HTMLSnippetElementComponent snippetElement) {
  }

  public void remove(HTMLSnippetElementComponent snippetElement) {
  }

  public String getHTMLContent() {
    String HTMLContent = "<" + tag + ">" + contentCore + "</" + tag + ">";

    return HTMLContent;
  }
}
