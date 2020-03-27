import java.util.Stack;

abstract public class Command implements Cloneable {
    public abstract void execute();

    public abstract void undo();
}

class Undo extends Command {
    protected Stack history;

    public Undo(Stack h) {
        history = h;
    }

    public void execute() {
        ((Command) history.firstElement()).undo();
    }

    public void undo() {
    }
}
