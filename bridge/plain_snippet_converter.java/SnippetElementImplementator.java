import java.util.ArrayList;

abstract class SnippetElementImplementator {
  protected String tag;
  protected String contentCore;
  protected ArrayList<SnippetElementImplementator> nestedElements;

  public SnippetElementImplementator(String tag, String contentCore) {
    this.tag = tag;
    this.contentCore = contentCore;
    this.nestedElements = new ArrayList<SnippetElementImplementator>();
  }

  public SnippetElementImplementator(String tag, ArrayList<SnippetElementImplementator> nestedElements) {
    this.tag = tag;
    this.nestedElements = nestedElements;
  }

  abstract public String getHTMLContent();
}
