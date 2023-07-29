import java.util.ArrayList;

class HTMLSnippetElementAdaptee {
  private String tag;
  private String contentCore;
  private ArrayList<HTMLSnippetElementAdaptee> nestedElements;

  public HTMLSnippetElementAdaptee(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
    this.nestedElements = new ArrayList<HTMLSnippetElementAdaptee>();
  }

  public HTMLSnippetElementAdaptee(String tag, ArrayList<HTMLSnippetElementAdaptee> nestedElements) {
    this.tag = tag;
    this.nestedElements = nestedElements;
  }

  public String getHTMLContent() {
    String content = "";

    if (nestedElements.size() == 0) {
      content = contentCore;
    } else {
      content = getNestedElementsHTMLContent();
    }

    String HTMLContent = "<" + tag + ">" + content + "</" + tag + ">";

    return HTMLContent;
  }

  private String getNestedElementsHTMLContent() {
    String nestedElementsHTMLContent = "";

    for(HTMLSnippetElementAdaptee nestedElement : nestedElements) {
      nestedElementsHTMLContent += nestedElement.getHTMLContent();
    }

    return nestedElementsHTMLContent;
  }
}
