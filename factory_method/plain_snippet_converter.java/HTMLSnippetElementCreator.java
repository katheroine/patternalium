class HTMLSnippetElementCreator extends SnippetElementCreator {
  public String factoryMethod() {
    String product = "";

    switch (elementType) {
      case "paragraph":
        product = createParagraph(elementCoreContent);
        break;
      case "list":
        product = createList(elementCoreContent);
        break;
      case "source":
        product = createSource(elementCoreContent);
        break;
    };

    return product;
  }

  String createParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    String paragraph = "<p>" + refinedParagraph + "</p>";

    return paragraph;
  }

  String createList(String rawList) {
    String list = "";
    String[] listItems = splitText(rawList);

    list += "<ul>";

    for (String rawListItem : listItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      list += "<li>" + refinedListItem + "</li>";
    }

    list += "</ul>";

    return list;
  }

  String createSource(String rawSource) {
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
