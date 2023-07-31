class HTMLSnippetElementProxy implements HTMLSnippetElementSubject {
  private HTMLSnippetElementSubject snippetElementSubject;
  private String snippetTag;
  private String snippetContentCore;

  public HTMLSnippetElementProxy(String tag, String contentCore) {
    snippetTag = tag;
    snippetContentCore = contentCore;
  }

  public String getHTMLContent() {
    return getSnippetElement().getHTMLContent();
  }

  private HTMLSnippetElementSubject getSnippetElement() {
    if (snippetElementSubject == null) {
      snippetElementSubject = new HTMLSnippetElementRealSubject(snippetTag, snippetContentCore);
    }

    return snippetElementSubject;
  }
}
