import org.w3c.dom.Node;
import java.util.ArrayList;

class XMLSnippetElementNonterminalExpression extends XMLSnippetElementAbstractExpression {
  private ArrayList<XMLSnippetElementAbstractExpression> nestedExpressions;

  public XMLSnippetElementNonterminalExpression(Node element, ArrayList<XMLSnippetElementAbstractExpression> nestedExpressions) {
    super(element);
    this.nestedExpressions = nestedExpressions;
  }

  public boolean interpret(XMLSnippetElementContext context) {
    for (XMLSnippetElementAbstractExpression nestedExpression : nestedExpressions) {
      if (! nestedExpression.interpret(context)) {
        return false;
      }
    }

    return (element.getNodeName() == context.getTag());
  }
}
