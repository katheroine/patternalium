class SnippetElementsListIterator implements SnippetElementsIterator {
  private int currentIndex;
  private SnippetElementsAggregate list;

  public SnippetElementsListIterator(SnippetElementsAggregate list) {
    this.list = list;
    currentIndex = 0;
  }

  public void first() {
    currentIndex = 0;
  }

  public void next() {
    currentIndex++;
  }

  public SnippetElement currentItem() {
    return list.get(currentIndex);
  }

  public boolean isDone() {
    return (currentIndex >= list.count());
  }
}
