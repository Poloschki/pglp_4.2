import java.util.Stack;

public class Interpreter {
  protected Stack<Double> history;
  protected Stack<Double> current;


  public Interpreter() {
    this.current = new Stack<>();
    this.history = new Stack<>();
  }

  public void undo() {
    this.current = this.history;
  }

  public void quit() {
    System.exit(0);
  }
}
