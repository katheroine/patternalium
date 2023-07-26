class HTMLSnippetElementCreator extends SnippetElementCreator {
  public SnippetElementProduct factoryMethod() {
    SnippetElementProduct product = new SnippetElementProduct();

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

  SnippetElementProduct createParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    String paragraph = "<p>" + refinedParagraph + "</p>";

    // return paragraph;
    return new HTMLSnippetElementProduct("p", refinedParagraph);
  }

  SnippetElementProduct createList(String rawList) {
    // String list = "";
    String[] listItems = splitText(rawList);
    String refinedList = "";

    // list += "<ul>";

    for (String rawListItem : listItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      // list += "<li>" + refinedListItem + "</li>";
      refinedList += "<li>" + refinedListItem + "</li>";
    }

    // list += "</ul>";

    // return list;
    return new HTMLSnippetElementProduct("ul", refinedList);
  }

  SnippetElementProduct createSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    String source = "<cite>" + refinedSource + "</cite>";

    // return source;
    return new HTMLSnippetElementProduct("cite", refinedSource);
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
