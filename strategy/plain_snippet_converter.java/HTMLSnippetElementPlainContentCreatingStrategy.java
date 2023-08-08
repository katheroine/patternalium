class HTMLSnippetElementPlainContentCreatingStrategy extends HTMLSnippetElementContentCreatingStrategy {
  public String createHTMLContent(HTMLSnippetElementContext snippetElementContext) {
    String HTMLContent = "<" + snippetElementContext.getTag() + ">" + snippetElementContext.getContentCore() + "</" + snippetElementContext.getTag() + ">";

    return HTMLContent;
  }
}
