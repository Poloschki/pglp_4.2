import java.util.Stack;

public class Enregistrement implements Command {
  protected double valeur;
  private MoteurRPN rpn;

  public Enregistrement(MoteurRPN rpn, double valeur) {
    this.rpn = rpn;
    this.valeur = valeur;
  }

  public void setValeur(double valeur) {
    this.valeur = valeur;
  }

  @Override
  public void execute() {
    this.rpn.history = (Stack<Double>) this.rpn.current.clone();
    this.rpn.current.push(this.valeur);
    System.out.println(this.rpn.current);
  }
}
