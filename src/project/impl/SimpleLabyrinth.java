package project.impl;

import project.base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleLabyrinth implements Labyrinth, DrawUnit {
    public static final int LABYRINTH_LAYER = 1;

    private ArrayList<Lever> levers;
    private ArrayList<Decoration> decorations;

    private ArrayList<ArrayList<MapTile>> map;
    private int exitX;
    private int exitY;

    private ArrayList<Interact> interacts;
    private ArrayList<UpdateUnit> updateUnits;

    public SimpleLabyrinth(ArrayList<Lever> levers, ArrayList<Decoration> decorations, ArrayList<ArrayList<MapTile>> map, int exitX, int exitY) {
        this.levers = levers;
        this.decorations = decorations;
        this.map = map;
        this.exitX = exitX;
        this.exitY = exitY;

        interacts = new ArrayList<>();
        for (Lever l: levers) {
            interacts.add(l);
        }

        updateUnits = new ArrayList<>();
        for (Decoration d: decorations) {
            updateUnits.add(d);
        }
    }

    @Override
    public boolean canExit() {
        for (Lever lever: levers) {
            if(!lever.isActive()) return false;
        }
        return true;
    }

    @Override
    public int getExitX() {
        return exitX;
    }

    @Override
    public int getExitY() {
        return exitY;
    }

    @Override
    public MapTile getMapTile(int x, int y) {
        if(y >= 0 && y < map.size() && x >= 0 && x < map.get(y).size())
            return map.get(y).get(x);
        else
            return SimpleMapTile.getBorderTile();
    }

    @Override
    public void addToDrawProcessor(DrawProcessor processor) {
        for (int y = 0; y < map.size(); ++y)
            for (int x = 0; x < map.get(y).size(); ++x)
                processor.addTile(getMapTile(x, y));
        for (Lever lever: levers) {
            processor.addTile(lever);
        }
        for (Decoration decoration: decorations) {
            processor.addTile(decoration);
        }
    }

    @Override
    public List<Interact> getInteracts() {
        return interacts;
    }

    @Override
    public List<UpdateUnit> getUpdateUnits() { return updateUnits; }
}
