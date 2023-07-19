class HTMLSnippetBuilder extends SnippetBuilder {
  String buildParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    String paragraph = "<p>" + refinedParagraph + "</p>";

    return paragraph;
  }

  String buildList(String rawList) {
    String list = "";
    String[] listItems = rawList.split("\\r?\\n|\\r");

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

  String buildSource(String rawSource) {
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
}
