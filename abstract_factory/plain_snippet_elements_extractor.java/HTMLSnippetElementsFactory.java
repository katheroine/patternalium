class HTMLSnippetElementsFactory extends SnippetElementsFactory {
  // String result = "";

  String createParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    String paragraph = "<p>" + refinedParagraph + "</p>";

    // result += paragraph;
    return paragraph;
  }

  String createList(String rawList) {
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

    // result += list;
    return list;
  }

  String createSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    String source = "<cite>" + refinedSource + "</cite>";

    // result += source;
    return source;
  }

  // public String getResult() {
  //   return result;
  // }

  static String refineText(String text) {
    return text
      .replaceAll("\\r\\n|\\r|\\n", "")
      .replaceAll("( )+", " ")
      .trim();
  }
}
