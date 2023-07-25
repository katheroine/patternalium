class HTMLParagraphElement extends ParagraphElement {
  private String contentCore;

  public HTMLParagraphElement(String contentCore) {
    this.contentCore = contentCore;
  }

  public String getParagraphContent() {
    return "<p>" + contentCore + "</p>";
  };
}
