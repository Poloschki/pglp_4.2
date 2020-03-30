import java.util.HashMap;

public class CommandCalculatrice {

    protected HashMap<String, Command> commandHashMap = new HashMap<>();
    protected MoteurRPN moteurRPN;

    public CommandCalculatrice(MoteurRPN moteurRPN) {
        this.moteurRPN = moteurRPN;
        this.register("undo", new Undo(this.moteurRPN));
        this.register("quit", new Quit(this.moteurRPN));
        this.register("calcul", new CommandOperation(Operation.PLUS, this.moteurRPN));
        this.register("enregistre", new Enregistrement(this.moteurRPN, 1.0));

    }

    public void register(String commandName, Command command) {
        commandHashMap.put(commandName, command);
    }

    public void setOperation(Operation operation) {
        CommandOperation tmp;
        if (commandHashMap.containsKey("calcul")) {
            tmp = (CommandOperation) this.commandHashMap.get("calcul");
            tmp.setOperation(operation);
        }
    }

    public void setEnregistrement(double valeur) {
        Enregistrement tmp;
        if (commandHashMap.containsKey("enregistre")) {
            tmp = (Enregistrement) this.commandHashMap.get("enregistre");
            tmp.setValeur(valeur);
        }
    }

    public void execute(String commandName) {
        Command command = commandHashMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("La commande " + commandName + " n'est pas connus");
        }
        command.execute();
    }
}