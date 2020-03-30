import java.util.HashMap;
import java.util.Stack;

public class Interpreter {
    protected Stack<Double> history;
    protected Stack<Double> current;
    protected HashMap<String, Command> commandHashMap = new HashMap<>();

    public Interpreter() {
        current = new Stack<>();
    }

    public void undo() {
        this.current = this.history;
    }

    public void quit() {
        System.exit(0);
    }
}
