public enum CalculatriceRPN {

    CALCULATRICE_RPN;

    private void run() throws PileException, OutOfBoundsException{
        SaisieRPN S  = new SaisieRPN();
        double resultat = S.calcul();
        System.out.println(resultat);
    }

    public static void main(String[] args) throws PileException, OutOfBoundsException {
        CALCULATRICE_RPN.run();
    }
}
