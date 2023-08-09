import java.util.ArrayList;

class HTMLSnippetElementMemento {
  ArrayList<HTMLSnippetElement> nestedSnippetElementsState;

  public HTMLSnippetElementMemento(ArrayList<HTMLSnippetElement> nestedSnippetElementsState) {
    this.nestedSnippetElementsState = new ArrayList<HTMLSnippetElement>(nestedSnippetElementsState);
  }

  public ArrayList<HTMLSnippetElement> getState() {
    return nestedSnippetElementsState;
  }
}
