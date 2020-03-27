import java.util.Scanner;

public class SaisieRPN {
    private MoteurRPN m;

    /**
     *
     * Constructeur de SaisieRPN qui initialise un MoteurRPN
     *
     */
    SaisieRPN(){
        this.m = new MoteurRPN();
    }

    /**
     * Fonction qui permet de pouvoir traiter l'entrée de l'utilisateur pour s'assurer de sa bonne entrée
     * @return La valeur finale du calcul.
     * @throws NumberFormatException La valeur entrée n'est pas un nombre.
     * @throws PileException Exception pour le moteurRPN
     * @throws OutOfBoundsException Exception pour le moteurRPN
     */
    public double calcul() throws NumberFormatException , PileException, OutOfBoundsException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.equals("exit")) {
            if(line.equals("+")||line.equals("-")||line.equals("*")||line.equals("/"))
            {
                if (line.equals("+")) {
                    this.m.operation(Operation.PLUS);
                }
                if (line.equals("-")) {
                    this.m.operation(Operation.MOINS);
                }
                if (line.equals("*")) {
                    this.m.operation(Operation.MULT);
                }
                if (line.equals("/")) {
                    this.m.operation(Operation.DIV);
                }

            }
            else
            {
                try {
                    Double.parseDouble(line);
                }
                catch(NumberFormatException e){
                    assert e.getMessage().equals("Format non respecté");
                }
                this.m.Enregistrer(line);
            }
            this.m.afficheoperandes();
            sc =new Scanner(System.in);
            line = sc.nextLine();
        }
        sc.close();
        return this.m.Operandes.peek();
    }

}