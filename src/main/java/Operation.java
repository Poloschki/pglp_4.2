public enum Operation {
  PLUS("+") {
    @Override
    public double eval(double op1, double op2) {
      return op1 + op2;
    }
  },
  MOINS("-") {
    @Override
    public double eval(double op1, double op2) {
      return op1 - op2;
    }
  },
  MULT("*") {
    @Override
    public double eval(double op1, double op2) {
      return op1 * op2;
    }
  },
  DIV("/") {
    /**
     * Override de eval.
     * @param op1 L'opérande gauche.
     * @param op2 L'opérande droite.
     * @return le résultat après exécution.
     */
    @Override
    public double eval(double op1, double op2) {
      if (op2 == 0) {
        throw new ArithmeticException("Division par 0");
      }
      return op1 / op2;
    }
  };
  private String symbole;

  /**
   * Constructeur des operations qui stocke le symbole.
   *
   * @param s le symbole qui doit être stocké.
   */
  Operation(String s) {
    this.symbole = s;
  }

  /**
   * Permet de savoir si le paramètre en argument
   * fait partie des symboles de l'énumération.
   *
   * @param string le string qu'on veut vérifier.
   * @return vrai si c'est un symbole connus faux sinon.
   */
  public static boolean isSymbole(String string) {
    for (Operation op : values()) {
      if (string.equals(op.getSymbole())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Permet d'avoir l'opérarion attribuer à un symbole.
   *
   * @param symbole le symbole qu'on veut vérifier.
   * @return soit l'opération soit un exception.
   */
  public static Operation getOperation(String symbole) {
    for (Operation op : values()) {
      if (symbole.equals(op.getSymbole())) {
        return op;
      }
    }
    throw new IllegalArgumentException();
  }

  /**
   * Getter du symbole de l'opération.
   *
   * @return Le symbole.
   */
  public String getSymbole() {
    return symbole;
  }

  /**
   * Fonction abstraite d'évaluation redéfinie pour chaque elément de l'opération.
   *
   * @param op1 L'opérande gauche.
   * @param op2 L'opérande droite.
   * @return Le resultat des deux opérandes selon l'opération.
   */
  public abstract double eval(double op1, double op2);
}
