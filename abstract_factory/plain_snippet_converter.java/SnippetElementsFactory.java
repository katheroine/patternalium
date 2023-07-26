class SnippetElementsFactory {
  ParagraphElement createParagraph(String rawParagraph) {
    return new ParagraphElement();
  };

  ListElement createList(String rawList) {
    return new ListElement();
  };

  SourceElement createSource(String rawSource) {
    return new SourceElement();
  };
}
