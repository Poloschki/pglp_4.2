import java.util.HashMap;

public class CommandCalculatrice {

  protected HashMap<String, Command> commandHashMap = new HashMap<>();
  protected MoteurRPN rpn;

  /**
   * Constructeur de commandeCalculatrice.
   *
   * @param rpn Le MoteurRPN
   */
  public CommandCalculatrice(MoteurRPN rpn) {
    this.rpn = rpn;
    this.register("undo", new Undo(this.rpn));
    this.register("quit", new Quit(this.rpn));
    this.register("calcul", new CommandOperation(Operation.PLUS, this.rpn));
    this.register("enregistre", new Enregistrement(this.rpn, 1.0));

  }

  /**
   * Enregistre la commande avec son nom.
   *
   * @param commandName le nom de la commande.
   * @param command     la commande correspondante.
   */
  public void register(String commandName, Command command) {
    commandHashMap.put(commandName, command);
  }

  /**
   * Change l'opération dans la map pour celle en paramètre.
   *
   * @param operation l'opération à enregister.
   */
  public void setOperation(Operation operation) {
    CommandOperation tmp;
    if (commandHashMap.containsKey("calcul")) {
      tmp = (CommandOperation) this.commandHashMap.get("calcul");
      tmp.setOperation(operation);
    }
  }

  /**
   * Change la valeur dans l'enregistrement.
   *
   * @param valeur la valeur à mettre dans la map
   */
  public void setEnregistrement(double valeur) {
    Enregistrement tmp;
    if (commandHashMap.containsKey("enregistre")) {
      tmp = (Enregistrement) this.commandHashMap.get("enregistre");
      tmp.setValeur(valeur);
    }
  }

  /**
   * Permet de lancer l'exécution selon si l'opération saisie.
   *
   * @param commandName l'opération
   */
  public void execute(String commandName) {
    Command command = commandHashMap.get(commandName);
    if (command == null) {
      throw new IllegalStateException("La commande " + commandName + " n'est pas connus");
    }
    command.execute();
  }
}