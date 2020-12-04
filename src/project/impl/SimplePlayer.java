package project.impl;

import project.base.DrawProcessor;
import project.base.Player;

public class SimplePlayer implements Player {
    private int x;
    private int y;
    private char c;
    private int layer;

    public SimplePlayer(int x, int y, char c, int layer) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.layer = layer;
    }

    @Override
    public void moveUp() {
        --y;
    }

    @Override
    public void moveDown() {
        ++y;
    }

    @Override
    public void moveLeft() {
        --x;
    }

    @Override
    public void moveRight() {
        ++x;
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        processor.addTile(this);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public char getChar() {
        return c;
    }

    @Override
    public int layer() {
        return layer;
    }
}
