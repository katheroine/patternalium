class HTMLSnippetElementProduct extends SnippetElementProduct {
  private String tag;
  private String contentCore;

  public HTMLSnippetElementProduct(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  public String getContent() {
    return "<" + tag + ">" + contentCore + "</" + tag + ">";
  };
}
