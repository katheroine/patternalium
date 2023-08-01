class HTMLSnippetElementConcreteComponent extends HTMLSnippetElementComponent {
  private String tag;
  private String contentCore;

  public HTMLSnippetElementConcreteComponent(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  public String getHTMLContent() {
    String HTMLContent = "<" + tag + ">" + contentCore + "</" + tag + ">";

    return HTMLContent;
  }

  public String getTag() {
    return tag;
  }
}
