import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoteurRPNTest {

    @Test
    public void testconstructeur() throws PileException
    {
        double valeur=5.23;
        MoteurRPN M= new MoteurRPN();
        M.empileval(valeur);
        assertEquals(valeur,M.depileval(),0);

    }

    @Test(expected = PileException.class)
    public void testdepiler() throws PileException
    {
        MoteurRPN M=new MoteurRPN();
        M.depileval();
    }

    @Test (expected = PileException.class)
    public void testoperation() throws PileException, OutOfBoundsException {
        //MoteurRPN M=new MoteurRPN();
        //M.operation("+");

    }

    @Test (expected = PileException.class)
    public void test1operation() throws PileException, OutOfBoundsException {
        //MoteurRPN M = new MoteurRPN();
        //M.operation("12");
        // M.operation("+");
    }

    @Test (expected = ArithmeticException.class)
    public void appliqueroperation() throws ArithmeticException, PileException, OutOfBoundsException {
        // MoteurRPN M=new MoteurRPN();
        // M.operation("0");
        // M.operation("19");
        //M.operation("/");
        // M.afficheoperandes();
    }

    @Test (expected = OutOfBoundsException.class)
    public void valeurTropGrande() throws PileException, OutOfBoundsException {
        //MoteurRPN M = new MoteurRPN();
        //M.operation("10000000000");
    }

    @Test (expected = OutOfBoundsException.class)
    public void valeurTropGrande2() throws PileException, OutOfBoundsException {
        //MoteurRPN M = new MoteurRPN();
        // M.operation("10000000");
        // M.operation("100000");
        // M.operation("*");
    }

    @Test (expected = OutOfBoundsException.class)
    public void valeurTropPetite() throws PileException, OutOfBoundsException {
        //MoteurRPN M = new MoteurRPN();
        // M.operation("-1000000000");
    }

    @Test (expected = OutOfBoundsException.class)
    public void valeurTropPetite2() throws PileException, OutOfBoundsException {
        //    MoteurRPN M = new MoteurRPN();
        //  M.operation("-10000000");
        // M.operation("100000");
        //M.operation("*");
    }

    @Test
    public void affichepile(){
        MoteurRPN m= new MoteurRPN();
        m.afficheoperandes();
    }
}