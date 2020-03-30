import java.util.Scanner;

public class SaisieRPN {
  protected CommandCalculatrice commandCalculatrice;
  private MoteurRPN rpn;
  private Scanner scanner;

  /**
   * Constructeur de SaisieRPN qui initialise un MoteurRPN.
   */
  SaisieRPN(MoteurRPN rpn) {
    this.rpn = rpn;
    this.commandCalculatrice = new CommandCalculatrice(this.rpn);
    this.scanner = new Scanner(System.in);
  }

  /**
   * Fonction qui permet de pouvoir traiter l'entrée de l'utilisateur
   * pour s'assurer de sa bonne entrée.
   *
   * @throws NumberFormatException La valeur entrée n'est pas un nombre.
   * @throws PileException         Exception pour le moteurRPN.
   * @throws OutOfBoundsException  Exception pour le moteurRPN.
   */
  public void entree() throws NumberFormatException, PileException, OutOfBoundsException {
    String line = scanner.nextLine();
    try {

      double resultat = Double.parseDouble(line);
      commandCalculatrice.setEnregistrement(resultat);
      commandCalculatrice.execute("enregistre");
    } catch (NumberFormatException e) {
      if (line.length() == 1 && Operation.isSymbole(line)) {
        commandCalculatrice.setOperation(Operation.getOperation(line));
        commandCalculatrice.execute("calcul");
      } else {
        commandCalculatrice.execute(line);
      }

    }
  }

}