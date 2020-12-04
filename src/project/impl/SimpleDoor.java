package project.impl;

import project.base.Door;
import project.base.DrawProcessor;
import project.base.Key;

public class SimpleDoor implements Door {

    private char code;
    private char openSymbol;
    private char closedSymbol;
    private int x;
    private int y;
    private int layer;
    private boolean isOpen = false;

    public SimpleDoor(char code, char openSymbol, char closedSymbol, int x, int y, int layer) {
        this.code = code;
        this.openSymbol = openSymbol;
        this.closedSymbol = closedSymbol;
        this.x = x;
        this.y = y;
        this.layer = layer;
    }


    @Override
    public void open(Key key) {
        if(key.getCode() == code) {
            isOpen = !isOpen;
            System.out.println("Ключ подошел, дверь открыта!");
        } else System.out.println("Этот ключ не подходит");
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        processor.addTile(this);
    }

    @Override
    public boolean interact() {
        return false;
    }

    @Override
    public String getLastMessage() {
        return null;
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
        if(isOpen) {
            return openSymbol;
        } else {
            return closedSymbol;
        }
    }

    @Override
    public int layer() {
        return layer;
    }
}
