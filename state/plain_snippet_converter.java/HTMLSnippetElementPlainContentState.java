class HTMLSnippetElementPlainContentState extends HTMLSnippetElementContentState {
  private String contentCore;

  public HTMLSnippetElementPlainContentState(String contentCore) {
    this.contentCore = contentCore;
  }

  public String handleGeneratingHTMLContent(HTMLSnippetElementContext snippetElementContext) {
    String HTMLContent = "<" + snippetElementContext.getTag() + ">" + contentCore + "</" + snippetElementContext.getTag() + ">";

    return HTMLContent;
  }
}
