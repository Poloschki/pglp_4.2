import java.util.Scanner;

public class SaisieRPN {
    private MoteurRPN m;
    protected CommandCalculatrice commandCalculatrice;
    private Scanner scanner;

    /**
     * Constructeur de SaisieRPN qui initialise un MoteurRPN
     */
    SaisieRPN(MoteurRPN m) {
        this.m = m;
        this.commandCalculatrice = new CommandCalculatrice(this.m);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Fonction qui permet de pouvoir traiter l'entrée de l'utilisateur pour s'assurer de sa bonne entrée
     *
     * @return La valeur finale du calcul.
     * @throws NumberFormatException La valeur entrée n'est pas un nombre.
     * @throws PileException         Exception pour le moteurRPN
     * @throws OutOfBoundsException  Exception pour le moteurRPN
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