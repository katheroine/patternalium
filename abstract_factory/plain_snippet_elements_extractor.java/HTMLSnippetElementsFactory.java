import java.util.ArrayList;

class HTMLSnippetElementsFactory extends SnippetElementsFactory {
  ParagraphElement createParagraph(String rawParagraph) {
    String refinedParagraph = refineText(rawParagraph);
    HTMLParagraphElement paragraph = new HTMLParagraphElement(refinedParagraph);

    return paragraph;
  }

  ListElement createList(String rawList) {
    String[] rawListItems = splitText(rawList);

    ArrayList<HTMLListItemElement> listItems = new ArrayList<HTMLListItemElement>();

    for (String rawListItem : rawListItems) {
      String refinedListItem = refineText(rawListItem);

      if (refinedListItem == "")
        continue;

      HTMLListItemElement listItem = new HTMLListItemElement(refinedListItem);
      listItems.add(listItem);
    }

    HTMLListElement list = new HTMLListElement(listItems);

    return list;
  }

  SourceElement createSource(String rawSource) {
    String refinedSource = refineText(rawSource);
    HTMLSourceElement source = new HTMLSourceElement(refinedSource);

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
