public class CommandCalculatrice extends Interpreter {


    public CommandCalculatrice() {
        commandHashMap.put("undo", new Undo(this));
        commandHashMap.put("quit", new Quit(this));
        commandHashMap.put("+", new CommandOperation(Operation.PLUS, this));
        commandHashMap.put("-", new CommandOperation(Operation.MOINS, this));
        commandHashMap.put("*", new CommandOperation(Operation.MULT, this));
        commandHashMap.put("/", new CommandOperation(Operation.DIV, this));

    }

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