import project.base.Game;
import project.impl.SimpleBuilder;
import project.impl.SimpleDrawProcessor;
import project.impl.SimpleGame;
import theory.*;

public class Main {
    public static void main(String[] args) {
        Game game = new SimpleGame(new SimpleDrawProcessor(), new SimpleBuilder());

        game.run();
//        Figure r = new Rectangle(10, 20);
//        Figure c = new Circle(5);
//
//        r.print();
//        c.print();
//
//        StaticFieldDemo.staticMethod();

//        AllDemo ad = new AllDemoImpl();
//
//        ad.defaultDemo();
//        ad.privateCall();
    }
}
