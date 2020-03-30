public class Quit implements Command {
  private Interpreter interpreter;

  public Quit(Interpreter interpreter) {
    this.interpreter = interpreter;
  }

  @Override
  public void execute() {
    this.interpreter.quit();
  }

}
