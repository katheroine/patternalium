class HTMLSnippetElementPrototype implements SnippetElementPrototype {
  private String elementType;
  // private String tag;
  private String contentCore;

  public HTMLSnippetElementPrototype(String elementType, String contentCore) {
    this.elementType = elementType;
    this.contentCore = contentCore;
  }

  public void setElementType(String elementType) {
    this.elementType = elementType;
  }

  public void setContentCore(String contentCore) {
    this.contentCore = contentCore;
  }

  @Override
  public SnippetElementPrototype clone() {
    HTMLSnippetElementPrototype clonnedSnippetElement = new HTMLSnippetElementPrototype(elementType, contentCore);

    return clonnedSnippetElement;
  }

  public String getContent() {
    String content = "";

    switch (elementType) {
      case "paragraph":
        content = genereteParagraph(contentCore);
        break;
      case "list":
        content = genereteList(contentCore);
        break;
      case "source":
        content = genereteSource(contentCore);
        break;
    };

    return content;
  }

  String genereteParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    String paragraph = "<p>" + refinedParagraph + "</p>";

    return paragraph;
  }

  String genereteList(String rawList) {
    String[] listItems = splitText(rawList);
    String refinedList = "";

    for (String rawListItem : listItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      refinedList += "<li>" + refinedListItem + "</li>";
    }

    String list = "<ul>" + refinedList + "</ul>";

    return list;
  }

  String genereteSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    String source = "<cite>" + refinedSource + "</cite>";

    return source;
  }

  static String refineText(String text) {
    return text
      .replaceAll("\\r\\n|\\r|\\n", "")
      .replaceAll("( )+", " ")
      .trim();
  }

  static String[] splitText(String text) {
    return text.split("\\r?\\n|\\r");
  }
}
