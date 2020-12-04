package theory;

public interface AllDemo {
    static final int INTEGER_CONSTANT = 10;

    default void defaultDemo() {
        System.out.println("Это реализауия по умолчанию");
    }

    private void privateDemo() {
        System.out.println("Это приватный метод");
    }

    default void privateCall() {
        privateDemo();
    }

    static void staticInterfaceDemo() {
        System.out.println("Статический метод интерфейса");
    }

    void abstractMethod();
}
