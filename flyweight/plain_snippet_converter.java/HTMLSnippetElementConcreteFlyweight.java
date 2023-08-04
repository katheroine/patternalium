class HTMLSnippetElementConcreteFlyweight implements HTMLSnippetElementFlyweight {
  private String tag;

  public HTMLSnippetElementConcreteFlyweight(String tag) {
    this.tag = tag;
  }

  public String getHTMLContent(String contentCore) {
    return "<" + tag + ">" + contentCore + "</" + tag + ">";
  }
}
