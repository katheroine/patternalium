class XMLSnippetElementContext {
  private String tag;
  private String[] nestedTags;

  public XMLSnippetElementContext(String tag) {
    this.tag = tag;
    nestedTags = new String[] {};
  }

  public XMLSnippetElementContext(String tag, String[] nestedTags) {
    this.tag = tag;
    this.nestedTags = nestedTags;
  }

  public String getTag() {
    return tag;
  }

  public String[] getNestedTags() {
    return nestedTags;
  }
}
