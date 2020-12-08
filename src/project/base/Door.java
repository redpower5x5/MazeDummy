package project.base;

public interface Door extends DrawUnit,Interact {
    boolean open(Key key);
    boolean isOpen();
    char getCode();
}
