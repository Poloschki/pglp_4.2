import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter {
    protected Stack history = new Stack();
    protected HashMap set = new HashMap();


    public void session() {
        while (true) {
            Command command = getNewCommand();
        }
    }

    protected Command getNewCommand() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        while ((!set.containsKey(s))) {
            System.out.println("Commande non valide");
            s = input.nextLine();
        }
        return (Command) set.get(s);

    }

    protected HashMap fillMap() {

    }

}
