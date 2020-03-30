import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OperationTest {

  @Test
  public void ExistanceEnum() {
    assertNotNull(Operation.valueOf("PLUS"));
    assertNotNull(Operation.valueOf("MOINS"));
    assertNotNull(Operation.valueOf("DIV"));
    assertNotNull(Operation.valueOf("MULT"));
  }

  @Test
  public void testOperationPLUS() {
    Operation a = Operation.PLUS;
    assertEquals("+", a.getSymbole());
  }

  @Test
  public void testOperationMOINS() {
    Operation a = Operation.MOINS;
    assertEquals("-", a.getSymbole());
  }

  @Test
  public void testOperationMULT() {
    Operation a = Operation.MULT;
    assertEquals("*", a.getSymbole());
  }

  @Test
  public void testOperationDIV() {
    Operation a = Operation.DIV;
    assertEquals("/", a.getSymbole());
  }

  @Test
  public void testPLUSeval() {
    Operation a = Operation.PLUS;
    double eval = a.eval(10, 10);
    assertEquals(20, eval, 0.00001);
  }

  @Test
  public void testMOINSeval() {
    Operation a = Operation.MOINS;
    double eval = a.eval(10, 11);
    assertEquals(-1, eval, 0.00001);
  }

  @Test
  public void testMULTeval() {
    Operation a = Operation.MULT;
    double eval = a.eval(10, 10);
    assertEquals(100, eval, 0.00001);
  }

  @Test
  public void testDIVeval() {
    Operation a = Operation.DIV;
    double eval = a.eval(10, 10);
    assertEquals(1, eval, 0.00001);
  }

  @Test(expected = ArithmeticException.class)
  public void testDIVeval0() {
    Operation a = Operation.DIV;
    double eval = a.eval(10, 0);
    assertEquals(1, eval, 0.00001);
  }

}