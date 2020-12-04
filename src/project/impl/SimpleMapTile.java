package project.impl;

import project.base.MapTile;

public class SimpleMapTile implements MapTile {
    private int x;
    private int y;
    private char c;
    private int layer;
    private boolean walkable;

    private static MapTile borderTile;

    public static MapTile getBorderTile() {
        if(borderTile == null) borderTile = new SimpleMapTile(-1, -1, ' ', -1, false);

        return borderTile;
    }

    public SimpleMapTile(int x, int y, char c, int layer, boolean walkable) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.layer = layer;
        this.walkable = walkable;
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
    @Override
    public boolean walkable() { return walkable; }
    @Override
    public void setWalkable(boolean b) {
        this.walkable = b;
    }

}
