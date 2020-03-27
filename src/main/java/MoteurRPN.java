
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
        if(this.Operandes.isEmpty()) throw new PileException();
        return this.Operandes.pop();
    }

    /**
     * Fonction qui permet de faire les opérations en fonction des entrées dans la pile, ou d'ajouer des valeurs à la pile
     *
     * @param S La chaîne de caractères à traiter
     * @throws PileException Si la pile ne contient pas le nombre adéquat d'opérandes
     * @throws OutOfBoundsException Si la valeur entrée est trop grande ou si le résultat dépasse la borne
     */
    public void operation(String S) throws PileException, OutOfBoundsException {
             if(S.equals("+"))
            {
                if(this.Operandes.size()<2)throw new PileException();
                double resultat = Operation.PLUS.eval(this.depileval(),this.depileval());
                if (resultat < -MAX_VALUE || resultat > MAX_VALUE) throw new OutOfBoundsException(resultat);
                this.empileval(resultat);
                System.out.println(this.Operandes.peek());
            }

            else
            {
                if(S.equals("-"))
                {
                    if(this.Operandes.size()<2)throw new PileException();
                    double resultat = Operation.MOINS.eval(this.depileval(),this.depileval());
                    if (resultat < -MAX_VALUE || resultat > MAX_VALUE) throw new OutOfBoundsException(resultat);
                    this.empileval(resultat);
                    System.out.println(this.Operandes.peek());
                }
                else
                {
                    if(S.equals("*"))
                    {
                        if(this.Operandes.size()<2)throw new PileException();
                        double resultat = Operation.MULT.eval(this.depileval(),this.depileval());
                        if (resultat < -MAX_VALUE || resultat > MAX_VALUE) throw new OutOfBoundsException(resultat);
                        this.empileval(resultat);
                        System.out.println(this.Operandes.peek());
                    }
                    else
                    {
                        if(S.equals("/"))
                        {
                            if(this.Operandes.size()<2)throw new PileException();
                            double resultat = Operation.DIV.eval(this.depileval(),this.depileval());
                            if (resultat < -MAX_VALUE || resultat > MAX_VALUE) throw new OutOfBoundsException(resultat);
                            this.empileval(resultat);
                            System.out.println(this.Operandes.peek());
                        }
                        else
                        {
                            double valeur = Double.parseDouble(S);
                            if (valeur < -MAX_VALUE || valeur > MAX_VALUE) throw new OutOfBoundsException(valeur);
                            this.empileval(valeur);
                        }
                    }
                }
            }
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
