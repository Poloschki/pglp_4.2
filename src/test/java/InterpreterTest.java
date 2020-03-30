import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {

  @Test
  public void undo() {
    Interpreter interpreter = new Interpreter();
    interpreter.current.push(2.0);
    interpreter.undo();
    assertEquals(interpreter.history, interpreter.current);
  }
}