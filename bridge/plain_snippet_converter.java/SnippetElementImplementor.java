import java.util.ArrayList;

abstract class SnippetElementImplementor {
  protected String tag;
  protected String contentCore;
  protected ArrayList<SnippetElementImplementor> nestedElements;

  public SnippetElementImplementor(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
    this.nestedElements = new ArrayList<SnippetElementImplementor>();
  }

  public SnippetElementImplementor(String tag, ArrayList<SnippetElementImplementor> nestedElements) {
    this.tag = tag;
    this.nestedElements = nestedElements;
  }

  abstract public String getHTMLContent();
}
