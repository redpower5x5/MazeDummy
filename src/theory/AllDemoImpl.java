package theory;

public abstract class AllDemoImpl implements AllDemo {
    @Override
    public void defaultDemo() {
        System.out.println("Реализация метода defaultDemo");
    }

    @Override
    public void privateCall() {
        AllDemo.super.privateCall();
        System.out.println("Дополнение privateCall");
    }
}
