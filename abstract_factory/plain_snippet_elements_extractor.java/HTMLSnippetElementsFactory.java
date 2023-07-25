import java.util.ArrayList;

class HTMLSnippetElementsFactory extends SnippetElementsFactory {
  String createParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    // String paragraph = "<p>" + refinedParagraph + "</p>";
    HTMLParagraphElement paragraph = new HTMLParagraphElement(refinedParagraph);

    return paragraph.getParagraphContent();
  }

  String createList(String rawList) {
    // String list = "";
    String[] rawListItems = splitText(rawList);

    // list += "<ul>";
    ArrayList<HTMLListItemElement> listItems = new ArrayList<HTMLListItemElement>();

    for (String rawListItem : rawListItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      HTMLListItemElement listItem = new HTMLListItemElement(refinedListItem);
      listItems.add(listItem);
      // list += listItem.getContent();
    }

    // list += "</ul>";
    HTMLListElement list = new HTMLListElement(listItems);

    return list.getListContent();
  }

  String createSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    // String source = "<cite>" + refinedSource + "</cite>";
    HTMLSourceElement source = new HTMLSourceElement(refinedSource);

    return source.getSourceContent();
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
