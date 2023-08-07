class HTMLSnippetPlainElementConcreteClass extends HTMLSnippetElementAbstractClass {
  private String contentCore;

  public HTMLSnippetPlainElementConcreteClass(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
  }

  protected String provideContentPrimitiveOperation() {
    return contentCore;
  }
}
