import java.util.ArrayList;

class HTMLListElement extends ListElement {
  private ArrayList<HTMLListItemElement> nestedElements;

  public HTMLListElement(ArrayList<HTMLListItemElement> nestedElements) {
    this.nestedElements = nestedElements;
  }

  public String getListContent() {
    String nestedContent = "";

    for (HTMLListItemElement nestedElement : nestedElements) {
      nestedContent += nestedElement.getListItemContent();
    }

    return "<ul>" + nestedContent + "</ul>";
  };
}
