package project.impl;

import project.base.*;

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
        return "Найден ключ "+code;
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
        System.out.println(getLastMessage());
        return this;
    }

    @Override
    public String getName() {
        return "Ключ "+code;
    }

    @Override
    public boolean performAction(GameStage gameStage) {
        Player player = gameStage.getPlayer();
        for (Door door: gameStage.getLabyrinth().getDoors()) {
            if(player.getX()+1 == door.getX()&& player.getY() == door.getY()) {
               return door.open(this);
            } else if (player.getX()-1 == door.getX()&& player.getY() == door.getY()) {
                return door.open(this);
            } else if (player.getX() == door.getX()&& player.getY()+1 == door.getY()) {
                return door.open(this);
            }else if (player.getX() == door.getX()&& player.getY()-1 == door.getY()) {
                return door.open(this);
            }
        }
        System.out.println("Нет двери поблизости!");
        return false;
    }
}
