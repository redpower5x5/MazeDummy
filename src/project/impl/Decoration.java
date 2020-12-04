package project.impl;

import project.base.DrawProcessor;
import project.base.DrawUnit;
import project.base.UpdateUnit;

public class Decoration implements UpdateUnit, DrawUnit {
    private int x;
    private int y;
    private int layer;

    private char[] characters;
    private int currentCharacter;

    public Decoration(int x, int y, int layer, char[] characters) {
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.characters = characters;
    }

    @Override
    public void update() {
        currentCharacter++;
        currentCharacter = currentCharacter % characters.length;
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
        return characters[currentCharacter];
    }

    @Override
    public int layer() {
        return layer;
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        processor.addTile(this);
    }
}
