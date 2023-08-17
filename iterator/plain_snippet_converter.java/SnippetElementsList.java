class SnippetElementsList implements SnippetElements {
  private SnippetElement[] elements;
  int size;

  public SnippetElementsList() {
    elements = new SnippetElement[] {};
    size = 0;
  }

  public int count() {
    return size;
  }

  public SnippetElement get(int index) {
    return elements[index];
  }

  public void add(SnippetElement element) {
    SnippetElement[] extendedElements = new SnippetElement[size + 1];
    extendedElements[size] = element;

    for (int i = 0; i < size; i++) {
      extendedElements[i] = elements[i];
    }

    elements = extendedElements;
    size++;
  }
}
