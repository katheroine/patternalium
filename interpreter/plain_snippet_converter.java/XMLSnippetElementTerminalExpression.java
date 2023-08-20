import java.util.Arrays;
import org.w3c.dom.Node;

class XMLSnippetElementTerminalExpression extends XMLSnippetElementAbstractExpression {
  public XMLSnippetElementTerminalExpression(Node element) {
    super(element);
  }

  public boolean interpret(XMLSnippetElementContext context) {
    return Arrays.asList(context.getNestedTags()).contains(element.getNodeName());
  }
}
