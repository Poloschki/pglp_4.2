import java.util.Stack;

public class Enregistrement implements Command {
    private double valeur;
    private MoteurRPN moteurRPN;

    public Enregistrement(MoteurRPN moteurRPN, double valeur) {
        this.moteurRPN = moteurRPN;
        this.valeur = valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public void execute() {
        this.moteurRPN.history = (Stack<Double>) this.moteurRPN.current.clone();
        this.moteurRPN.current.push(this.valeur);
        System.out.println(this.moteurRPN.current);
    }
}
