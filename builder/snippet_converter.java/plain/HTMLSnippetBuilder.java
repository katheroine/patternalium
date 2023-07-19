class HTMLSnippetBuilder extends SnippetBuilder {
  String buildParagraph(String rawParagraph) {
    return "PARAGRAPH";
  }

  String buildList(String rawList) {
    return "LIST";
  }

  String buildSource(String rawSource) {
    return "SOURCE";
  }
}
