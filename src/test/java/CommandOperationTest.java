import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandOperationTest {

  @Test
  public void checkSize() {
    MoteurRPN moteurRPN = new MoteurRPN();
    CommandOperation commandOperation = new CommandOperation(Operation.PLUS, moteurRPN);
    moteurRPN.current.push(1.1);
    assertFalse(commandOperation.checkSize());
    moteurRPN.current.push(2.2);
    assertTrue(commandOperation.checkSize());
  }

}