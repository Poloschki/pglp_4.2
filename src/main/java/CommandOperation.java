import java.util.Stack;

public class CommandOperation implements Command {

    private Operation operation;
    private MoteurRPN moteurRPN;

    public CommandOperation(Operation operation, MoteurRPN moteurRPN) {
        this.moteurRPN = moteurRPN;
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean checkSize() {
        return this.moteurRPN.current.size() > 1;
    }

    @Override
    public void execute() {
        this.moteurRPN.history = (Stack<Double>) this.moteurRPN.current.clone();
        if (checkSize())
            this.moteurRPN.current.push(operation.eval(this.moteurRPN.current.pop(), this.moteurRPN.current.pop()));
        System.out.println(this.moteurRPN.current);
    }
}
