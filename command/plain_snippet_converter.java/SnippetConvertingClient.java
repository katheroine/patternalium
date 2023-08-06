class SnippetConvertingClient {
  private static String snippetInputFilePath = "./input/snippet.xml";
  private static String snippetOutputFilePath = "./output/snippet.html";

  public static void main(String[] args) {
      SnippetPersistingReceiver receiver = new SnippetPersistingReceiver(snippetOutputFilePath);
      SnippetExtractingConcreteCommand command = new SnippetExtractingConcreteCommand(snippetInputFilePath, receiver);
      SnippetConvertingInvoker invoker = new SnippetConvertingInvoker();
      invoker.setCommand(command);
      invoker.executeCommand();
  }
}
