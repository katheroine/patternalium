import java.util.ArrayList;

class HTMLSnippetElementContext {
  private String tag;
  private String contentCore;
  private String nestedElementsTag;
  private ArrayList<String> nestedElementsContentCores;
  private HTMLSnippetElementContentCreatingStrategy contentCreatingStrategy;

  public HTMLSnippetElementContext(String tag, String contentCore, HTMLSnippetElementContentCreatingStrategy contentCreatingStrategy) {
    this.tag = tag;
    this.nestedElementsTag = "";
    this.contentCore = contentCore;
    this.nestedElementsContentCores = new ArrayList<String>();
    this.contentCreatingStrategy = contentCreatingStrategy;
  }

  public HTMLSnippetElementContext(String tag, String nestedElementsTag, ArrayList<String> nestedElementsContentCores, HTMLSnippetElementContentCreatingStrategy contentCreatingStrategy) {
    this.tag = tag;
    this.nestedElementsTag = nestedElementsTag;
    this.contentCore = "";
    this.nestedElementsContentCores = nestedElementsContentCores;
    this.contentCreatingStrategy = contentCreatingStrategy;
  }

  public String getTag() {
    return tag;
  }

  public String getNestedElementsTag() {
    return nestedElementsTag;
  }

  public String getContentCore() {
    return contentCore;
  }

  public ArrayList<String> getNestedElementsContentCores() {
    return nestedElementsContentCores;
  }

  public String getHTMLContent() {
    return contentCreatingStrategy.createHTMLContent(this);
  }
}
