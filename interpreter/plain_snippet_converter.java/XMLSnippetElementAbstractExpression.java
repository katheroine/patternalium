import org.w3c.dom.Node;

abstract class XMLSnippetElementAbstractExpression {
  protected Node element;

  protected XMLSnippetElementAbstractExpression(Node element) {
    this.element = element;
  }

  abstract public boolean interpret(XMLSnippetElementContext context);
}
