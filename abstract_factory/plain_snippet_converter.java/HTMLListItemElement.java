class HTMLListItemElement extends ListItemElement {
  private String contentCore;

  public HTMLListItemElement(String contentCore) {
    this.contentCore = contentCore;
  }

  public String getListItemContent() {
    return "<li>" + contentCore + "</li>";
  };
}
