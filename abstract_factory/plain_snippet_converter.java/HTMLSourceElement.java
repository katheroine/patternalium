class HTMLSourceElement extends SourceElement {
  private String contentCore;

  public HTMLSourceElement(String contentCore) {
    this.contentCore = contentCore;
  }

  public String getSourceContent() {
    return "<cite>" + contentCore + "</cite>";
  };
}
