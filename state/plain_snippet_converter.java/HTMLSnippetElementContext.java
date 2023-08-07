class HTMLSnippetElementContext {
  private String tag;
  private HTMLSnippetElementContentState contentState;

  public HTMLSnippetElementContext(String tag) {
    this.tag = tag;
  }

  public void changeContentState(HTMLSnippetElementContentState contentState) {
    this.contentState = contentState;
  }

  public String getTag() {
    return tag;
  }

  public String getHTMLContent() {
    return contentState.handleGeneratingHTMLContent(this);
  }
}
