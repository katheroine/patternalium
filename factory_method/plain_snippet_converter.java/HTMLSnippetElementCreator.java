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

    return new HTMLSnippetElementProduct("p", refinedParagraph);
  }

  SnippetElementProduct createList(String rawList) {
    String[] listItems = splitText(rawList);
    String refinedList = "";

    for (String rawListItem : listItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      refinedList += "<li>" + refinedListItem + "</li>";
    }

    return new HTMLSnippetElementProduct("ul", refinedList);
  }

  SnippetElementProduct createSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    String source = "<cite>" + refinedSource + "</cite>";

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
