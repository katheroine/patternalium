abstract class HTMLSnippetElementAbstractClass {
  protected String tag;

  public String getHTMLContentTemplateMethod() {
    String content = provideContentPrimitiveOperation();
    String HTMLContent = constructHTMLContent(content);

    return HTMLContent;
  }

  abstract protected String provideContentPrimitiveOperation();

  private String constructHTMLContent(String content) {
    String HTMLContent = "<" + tag + ">" + content + "</" + tag + ">";

    return HTMLContent;
  }
}
