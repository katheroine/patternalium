import java.util.ArrayList;

class HTMLSnippetNestingElementConcreteClass extends HTMLSnippetElementAbstractClass {
  private String nestesElementsTag;
  private ArrayList<String> nestedElementsContentCores;

  public HTMLSnippetNestingElementConcreteClass(String tag, String nestesElementsTag, ArrayList<String> nestedElementsContentCores) {
    this.tag = tag;
    this.nestesElementsTag = nestesElementsTag;
    this.nestedElementsContentCores = nestedElementsContentCores;
  }

  protected String provideContentPrimitiveOperation() {
    String nestedElementsHTMLContent = "";

    for(String nestedElementContentCore : nestedElementsContentCores) {
      nestedElementsHTMLContent += "<" + nestesElementsTag + ">" + nestedElementContentCore + "</" + nestesElementsTag + ">";
    }

    return nestedElementsHTMLContent;
  }
}
