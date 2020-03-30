import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandCalculatriceTest {

  @Test
  public void register() {
    MoteurRPN moteurRPN = new MoteurRPN();
    CommandCalculatrice cc = new CommandCalculatrice(moteurRPN);
    assertTrue(cc.commandHashMap.containsKey("undo"));
    assertTrue(cc.commandHashMap.containsKey("quit"));
    assertTrue(cc.commandHashMap.containsKey("calcul"));
    assertTrue(cc.commandHashMap.containsKey("enregistre"));
  }

}