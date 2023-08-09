class HTMLSnippetPlainElement extends HTMLSnippetElement {
  private String contentCore;

  public HTMLSnippetPlainElement(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  public String getHTMLContent() {
    String HTMLContent = "<" + tag + ">" + contentCore + "</" + tag + ">";

    return HTMLContent;
  }
}
