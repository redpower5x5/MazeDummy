package project.base;

public interface Inventary {
    void addToInventary(InventaryItem item);
    String drawInventary();
    void selectAndUseItemAt(int i, GameStage gameStage);
}
