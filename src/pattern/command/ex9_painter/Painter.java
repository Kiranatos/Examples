package pattern.command.ex9_painter;

public class Painter {

    public static void main(String[] args) {
        Holst h = new Holst();
        UserInterface ui = new UserInterface(h);
        ui.paint();
        h.show();
        ui.clear();
        h.show();
    }
}

// Ресивер
class Holst {
    int line = 0;
    public void showLine() { line++; }
    public void deleteLine() { line--; }
    public void show() { System.out.println(line); }
}

//Инвокер
class UserInterface {
    private Command2 obj;        

    public UserInterface(Holst h) { obj = new LineCommand(h); }
    
    public void paint() { obj.execute(); }

    public void clear() { obj.undo(); }
}

//Классы-команды
interface Command2 {
    public void undo();
    public void execute();
}

class LineCommand implements Command2 {
    Holst h;

    public LineCommand(Holst h) { this.h = h; }

    @Override
    public void undo() { h.deleteLine(); }

    @Override
    public void execute() { h.showLine(); }
}
