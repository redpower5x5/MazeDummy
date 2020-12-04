package project.impl;

import project.base.DrawProcessor;
import project.base.Tile;

import java.util.ArrayList;

public class SimpleDrawProcessor implements DrawProcessor {
    private ArrayList<Tile> tiles;
    private char[][] drawBuffer;

    public SimpleDrawProcessor() {
        tiles = new ArrayList<>();
    }

    @Override
    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    @Override
    public void drawAll() {
        drawBuffer = createBuffer();
        draw();
        tiles.clear();
    }

    private char[][] createBuffer() {
        int maxX = 0;
        int maxY = 0;
        for (Tile tile: tiles) {
            if(tile.getX() > maxX) maxX = tile.getX();
            if(tile.getY() > maxY) maxY = tile.getY();
        }
        char[][] buffer = new char[maxY + 1][maxX + 1];
        int[][] layers = new int[maxY + 1][maxX + 1];
        for (Tile tile: tiles) {
            if(tile.layer() > layers[tile.getY()][tile.getX()])
                buffer[tile.getY()][tile.getX()] = tile.getChar();
        }
        return buffer;
    }
    private void draw() {
        for (int i = 0; i < drawBuffer.length; ++i) {
            for (int j = 0; j < drawBuffer[i].length; ++j) {
                System.out.print(drawBuffer[i][j]);
            }
            System.out.println();
        }
    }
}
