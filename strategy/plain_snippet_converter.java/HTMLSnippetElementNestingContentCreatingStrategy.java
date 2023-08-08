class HTMLSnippetElementNestingContentCreatingStrategy extends HTMLSnippetElementContentCreatingStrategy {
  public String createHTMLContent(HTMLSnippetElementContext snippetElementContext) {
    String content = getNestedElementsHTMLContent(snippetElementContext);
    String HTMLContent = "<" + snippetElementContext.getTag() + ">" + content + "</" + snippetElementContext.getTag() + ">";

    return HTMLContent;
  }

  private String getNestedElementsHTMLContent(HTMLSnippetElementContext snippetElementContext) {
    String nestedElementsHTMLContent = "";

    for(String nestedElementContentCore : snippetElementContext.getNestedElementsContentCores()) {
      nestedElementsHTMLContent += "<" + snippetElementContext.getNestedElementsTag() + ">" + nestedElementContentCore + "</" + snippetElementContext.getNestedElementsTag() + ">";
    }

    return nestedElementsHTMLContent;
  }
}
