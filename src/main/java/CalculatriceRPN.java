public enum CalculatriceRPN {

    CALCULATRICE_RPN;

    private void run() throws PileException, OutOfBoundsException{
        MoteurRPN m = new MoteurRPN();
        SaisieRPN S = new SaisieRPN(m);
        while (true) {
            S.entree();
        }

    }

    public static void main(String[] args) throws PileException, OutOfBoundsException {
        CALCULATRICE_RPN.run();
    }
}
