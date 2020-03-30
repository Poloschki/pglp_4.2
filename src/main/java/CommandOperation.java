public class CommandOperation implements Command {

    private Operation operation;
    private Interpreter interpreter;

    public CommandOperation(Operation operation, Interpreter interpreter) {
        this.interpreter = interpreter;
        this.operation = operation;
    }

    @Override
    public void execute() {
        this.interpreter.current.push(operation.eval(this.interpreter.current.pop(), this.interpreter.current.pop()));
    }
}
