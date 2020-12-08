package project.impl;

import project.base.DrawProcessor;
import project.base.GameStage;
import project.base.InventaryItem;
import project.base.Treasure;

public class SimpleTreasure implements Treasure {

    private String type;
    private char symbol;
    private int x;
    private int y;
    private int layer;

    public SimpleTreasure(String type, char symbol, int x, int y, int layer) {
        this.type = type;
        this.symbol = symbol;
        this.x = x;
        this.y = y;
        this.layer = layer;
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        processor.addTile(this);
    }

    @Override
    public InventaryItem getItem() {
        System.out.println(getLastMessage());
        return this;
    }

    @Override
    public String getLastMessage() {
        return "Найдено сокровещие: "+getType();
    }

    @Override
    public String getName() {
        return "Сокровище: "+getType();
    }

    @Override
    public boolean performAction(GameStage gameStage) {
        System.out.println("Очень ценная вещь, оставлю ее себе");
        return false;
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
    public String getType() {
        return type;
    }
}
