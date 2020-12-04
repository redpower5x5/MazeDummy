package project.impl;

import project.base.DrawProcessor;
import project.base.InventaryItem;
import project.base.Key;

public class SimpleKey implements Key {

    private char code;
    private char symbol;
    private int x;
    private int y;
    private int layer;

    public SimpleKey(char code, char symbol, int x, int y, int layer) {
        this.code = code;
        this.symbol = symbol;
        this.x = x;
        this.y = y;
        this.layer = layer;
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        processor.addTile(this);
    }

    @Override
    public String getLastMessage() {
        String s = "Найден ключ "+code;
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
        return symbol;
    }

    @Override
    public int layer() {
        return layer;
    }

    @Override
    public InventaryItem getItem() {
        return null;
    }
}
