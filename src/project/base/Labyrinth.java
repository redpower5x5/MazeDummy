package project.base;

import java.util.List;

public interface Labyrinth extends DrawUnit {
    MapTile getMapTile(int x, int y);
    List<Interact> getInteracts();
    List<UpdateUnit> getUpdateUnits();

    int getExitX();
    int getExitY();

    boolean canExit();
}
