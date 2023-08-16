import java.util.ArrayList;

class HTMLSnippetElementConvertingVisitor extends HTMLSnippetElementVisitor {
  private ArrayList<String> convertedElements;

  public HTMLSnippetElementConvertingVisitor() {
    convertedElements = new ArrayList<String>();
  }

  public void visitSnippetPlainElement(HTMLSnippetPlainElement snippetElement) {
    String convertedElement = "<" + snippetElement.getTag() + ">" + snippetElement.getContentCore() + "</" + snippetElement.getTag() + ">";
    convertedElements.add(convertedElement);
  }

  public void visitSnippetNestingElement(HTMLSnippetNestingElement snippetElement) {
    ArrayList<String> nestedConvertedElements = new ArrayList<String>();
    String nestedConvertedElement;

    for (HTMLSnippetPlainElement nestedElement : snippetElement.getNestedElements()) {
      nestedConvertedElement = "<" + nestedElement.getTag() + ">" + nestedElement.getContentCore() + "</" + nestedElement.getTag() + ">";
      nestedConvertedElements.add(nestedConvertedElement);
    }

    String snippetElementContentCore = String.join("", nestedConvertedElements);
    String convertedElement = "<" + snippetElement.getTag() + ">" + snippetElementContentCore + "</" + snippetElement.getTag() + ">";
    convertedElements.add(convertedElement);
  }

  public ArrayList<String> getConvertedElements() {
    return convertedElements;
  }
}
