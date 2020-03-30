public class Undo implements Command {

    private Interpreter interpreter;

    public Undo(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public void execute() {
        this.interpreter.undo();
    }
}
