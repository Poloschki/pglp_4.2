import java.util.Stack;

public class MoteurRPN {



    /**
     * Pile d'opérandes.
     */
    public Stack<Double> Operandes;


    /**
     * Valeur maximale pouvant être traité par les opérations ou pouvant être ajouté sur la pile.
     */
    private static final double MAX_VALUE = 100000000;

    /**
     * Constructeur du moteur RPN qui initialise la pile d'opérandes.
     */
    public MoteurRPN()
    {
        this.Operandes=new Stack<Double>();
    }

    /**
     * Fonction pour empiler les opérandes dans la pile.
     *
     * @param valeur La valeur à empiler dans la pile
     */
    public void empileval(double valeur)
    {
        this.Operandes.push(valeur);
    }

    /**
     * Fonction qui dépile la valeur la plus haute de la pile.
     *
     * @return La valeur depilée.
     * @throws PileException La pile est vide, il n'y a rien a dépiler.
     */
    public double depileval() throws PileException {
        if (this.Operandes.isEmpty()) throw new PileException();
        return this.Operandes.pop();
    }

    public void Enregistrer(String S) throws OutOfBoundsException {
        double valeur = Double.parseDouble(S);
        if (valeur < -MAX_VALUE || valeur > MAX_VALUE) throw new OutOfBoundsException(valeur);
        this.empileval(valeur);
    }

    /**
     * Fonction qui permet de faire les opérations en fonction des entrées dans la pile, ou d'ajouer des valeurs à la pile
     *
     * @param //La chaîne de caractères à traiter
     * @throws PileException        Si la pile ne contient pas le nombre adéquat d'opérandes
     * @throws OutOfBoundsException Si la valeur entrée est trop grande ou si le résultat dépasse la borne
     */
    public void operation(Operation o) throws PileException, OutOfBoundsException {
        if (this.Operandes.size() < 2) throw new PileException();
        double resultat = o.eval(this.depileval(), this.depileval());
        if (resultat < -MAX_VALUE || resultat > MAX_VALUE) throw new OutOfBoundsException(resultat);
        this.empileval(resultat);
        System.out.println(this.Operandes.peek());
    }


    /**
     * Affiche la pile d'opérandes stockées
     *
     */
    public void afficheoperandes()
    {
        System.out.println(this.Operandes);

    }







}