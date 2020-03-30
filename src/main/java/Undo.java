public class Undo implements Command {

  private MoteurRPN moteurRpn;

  public Undo(MoteurRPN moteurRpn) {
    this.moteurRpn = moteurRpn;
  }

  @Override
  public void execute() {
    this.moteurRpn.undo();
    System.out.println(this.moteurRpn.current);
  }
}
