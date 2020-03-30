import java.util.Stack;

public class CommandOperation implements Command {

  private Operation operation;
  private MoteurRPN rpn;

  public CommandOperation(Operation operation, MoteurRPN rpn) {
    this.rpn = rpn;
    this.operation = operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public boolean checkSize() {
    return this.rpn.current.size() > 1;
  }

  @Override
  public void execute() {
    this.rpn.history = (Stack<Double>) this.rpn.current.clone();
    if (checkSize()) {
      this.rpn.current.push(operation.eval(this.rpn.current.pop(),
          this.rpn.current.pop()));
    }

    System.out.println(this.rpn.current);
  }
}
