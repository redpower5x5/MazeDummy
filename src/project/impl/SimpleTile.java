package project.impl;

import project.base.Tile;

public class SimpleTile implements Tile {
    private int x;
    private int y;
    private char c;
    private int layer;

    public SimpleTile(int x, int y, char c, int layer) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.layer = layer;
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
