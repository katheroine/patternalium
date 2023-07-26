class SnippetElementCreator {
  protected String elementType;
  protected String elementCoreContent;

  public SnippetElementProduct factoryMethod() {
    return new SnippetElementProduct();
  }

  public void setElementTypeOperation(String elementType) {
    this.elementType = elementType;
  }

  public void setElementCoreContentOperation(String elementCoreContent) {
    this.elementCoreContent = elementCoreContent;
  }
}
