public class CommandQuit implements Command {
  private Interpreter interpreter;

  public CommandQuit(Interpreter interpreter) {
    this.interpreter = interpreter;
  }

  @Override
  public void execute() {
    this.interpreter.quit();
  }
}
