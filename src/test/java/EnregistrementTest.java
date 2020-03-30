import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnregistrementTest {

  @Test
  public void setValeur() {
    MoteurRPN moteurRPN = new MoteurRPN();
    Enregistrement enregistrement = new Enregistrement(moteurRPN, 1.1);
    enregistrement.setValeur(2.0);
    assertEquals(2.0, enregistrement.valeur, 1);
  }
}