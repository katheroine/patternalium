import java.util.ArrayList;
import java.io.IOException;

abstract class SnippetConvertingSubject {
  protected ArrayList<SnippetConvertingObserver> convertingObservers;

  public SnippetConvertingSubject() {
    convertingObservers = new ArrayList<SnippetConvertingObserver>();
  }

  public void attach(SnippetConvertingObserver convertingObserver) {
    convertingObservers.add(convertingObserver);
  }

  public void detach(SnippetConvertingObserver convertingObserver) {
    convertingObservers.remove(convertingObserver);
  }

  public void makeNotification() throws IOException {
    for (SnippetConvertingObserver convertingObserver : convertingObservers) {
      convertingObserver.update();
    }
  }
}
