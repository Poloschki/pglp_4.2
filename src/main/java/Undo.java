public class Undo implements Command {

    private MoteurRPN moteurRPN;

    public Undo(MoteurRPN moteurRPN) {
        this.moteurRPN = moteurRPN;
    }

    @Override
    public void execute() {
        this.moteurRPN.undo();
        System.out.println(this.moteurRPN.current);
    }
}
