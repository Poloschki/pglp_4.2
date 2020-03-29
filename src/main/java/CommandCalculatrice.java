import java.util.HashMap;

public class CommandCalculatrice {
    private final HashMap<String, Command> commandHashMap = new HashMap<>();

    public void register(String oommandName, Command command) {
        commandHashMap.put(oommandName, command);
    }

    public void execute(String commandName) {
        Command command = commandHashMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("La commande " + commandName + " n'est pas connus");
        }
        command.execute();
    }
}
