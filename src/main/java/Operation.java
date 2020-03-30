public enum Operation {
    PLUS("+") {
        public double eval(double op1, double op2) {
            return op1 + op2;
        }
    },
    MOINS("-") {
        public double eval(double op1, double op2) {
            return op1 - op2;
        }
    },
    MULT("*") {
        public double eval(double op1, double op2) {
            return op1 * op2;
        }
    },
    DIV("/") {
        public double eval(double op1, double op2) {
            if (op2==0) throw new ArithmeticException("Division par 0");
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

    public static boolean isSymbole(String aVerifier) {
        for (Operation op : values()) {
            if (aVerifier.equals(op.getSymbole())) return true;
        }
        return false;
    }

    public static Operation getOperation(String symbole) {
        for (Operation op : values()) {
            if (symbole.equals(op.getSymbole())) return op;
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
