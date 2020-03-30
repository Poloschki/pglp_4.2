enum CalculatriceRpn {

  CALCULATRICE_RPN;

  public static void main(String[] args) throws PileException, OutOfBoundsException {
    CALCULATRICE_RPN.run();
  }

  private void run() throws PileException, OutOfBoundsException {
    MoteurRPN rpn = new MoteurRPN();
    SaisieRPN saisie = new SaisieRPN(rpn);
    while (true) {
      saisie.entree();
    }

  }
}
