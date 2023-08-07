import java.util.ArrayList;

class HTMLSnippetElementNestingContentState extends HTMLSnippetElementContentState {
  private String nestesElementsTag;
  private ArrayList<String> nestedElementsContentCores;

  public HTMLSnippetElementNestingContentState(String nestesElementsTag, ArrayList<String> nestedElementsContentCores) {
    this.nestesElementsTag = nestesElementsTag;
    this.nestedElementsContentCores = nestedElementsContentCores;
  }

  public String handleGeneratingHTMLContent(HTMLSnippetElementContext snippetElementContext) {
    String content = getNestedElementsHTMLContent();
    String HTMLContent = "<" + snippetElementContext.getTag() + ">" + content + "</" + snippetElementContext.getTag() + ">";

    return HTMLContent;
  }

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(String nestedElementContentCore : nestedElementsContentCores) {
      nestedElementsHTMLContent += "<" + nestesElementsTag + ">" + nestedElementContentCore + "</" + nestesElementsTag + ">";
    }

    return nestedElementsHTMLContent;
  }
}
