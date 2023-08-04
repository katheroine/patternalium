import java.util.HashMap;
import java.util.Map;

class HTMLSnippetElementFlyweightFactory {
  private static Map<String, HTMLSnippetElementFlyweight> snippetElements = new HashMap<String, HTMLSnippetElementFlyweight>();

  public static HTMLSnippetElementFlyweight getSnippetElement(String tag) {
    HTMLSnippetElementFlyweight snippetElement = (HTMLSnippetElementFlyweight) snippetElements.get(tag);

    if (snippetElement == null) {
        snippetElement = new HTMLSnippetElementConcreteFlyweight(tag);
        snippetElements.put(tag, snippetElement);
    }

    return snippetElement;
  }
}
