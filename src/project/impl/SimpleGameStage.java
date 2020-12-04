package project.impl;

import project.base.GameStage;
import project.base.Labyrinth;
import project.base.Player;

public class SimpleGameStage implements GameStage {
    private Labyrinth labyrinth;
    private Player player;

    public SimpleGameStage(Labyrinth labyrinth, Player player) {
        this.labyrinth = labyrinth;
        this.player = player;
    }

    @Override
    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
