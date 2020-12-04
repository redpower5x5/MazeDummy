package project.base;

public interface Player extends Tile, DrawUnit {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
