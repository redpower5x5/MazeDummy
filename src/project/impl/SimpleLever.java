package project.impl;

import project.base.DrawProcessor;
import project.base.Lever;

public class SimpleLever implements Lever {
    private char activeSymbol;
    private char noActiveSymbol;
    private int x;
    private int y;
    private int layer;
    private boolean isActive;

    public SimpleLever(char activeSymbol, char noActiveSymbol, int x, int y, int layer) {
        this.activeSymbol = activeSymbol;
        this.noActiveSymbol = noActiveSymbol;
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.isActive = false;
    }

    @Override
    public boolean interact() {
        isActive = !isActive;
        return true;
    }

    @Override
    public String getLastMessage() {
        if(isActive())
            return "Рычаг активирован";
        return "Рычаг деактивирован";
    }

    @Override
    public boolean isActive() {
        return isActive;
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
        return isActive ? activeSymbol : noActiveSymbol;
    }

    @Override
    public int layer() {
        return layer;
    }
}
