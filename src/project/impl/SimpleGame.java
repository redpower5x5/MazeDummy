package project.impl;

import project.base.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleGame implements Game {
    private DrawProcessor drawProcessor;
    private Builder builder;
    private ArrayList<String> levels;
    private GameStage currentLevel;

    public SimpleGame(DrawProcessor drawProcessor, Builder builder) {
        this.drawProcessor = drawProcessor;
        this.builder = builder;
    }

    private void updateAll() {
        for (UpdateUnit u: currentLevel.getLabyrinth().getUpdateUnits()) {
            u.update();
        }
    }

    @Override
    public void run() {
        if(!readLevels()) {
            System.out.println("Что-то пошло не так при чтении названий уровней...");
            return;
        }

        for (String levelName: levels) {
            currentLevel = builder.build(levelName);
            System.out.println("Добро пожаловать на уровень " + levelName);
            while (!levelComplete())
            {
                updateAll();

                currentLevel.getLabyrinth().addToDrawProcessor(drawProcessor);
                currentLevel.getPlayer().addToDrawProcessor(drawProcessor);

                drawProcessor.drawAll();

                playerCommandProcess();
            }
            System.out.println("Вы покидаете " + levelName);
        }

        System.out.println("Вы успешно выбрались из подземелья!");
    }

    private void playerCommandProcess() {
        System.out.println("Введите команду (u/d/l/r/t/e)");
        Scanner scanner = new Scanner(System.in);
        String com = scanner.nextLine();
        Player player = currentLevel.getPlayer();
        Labyrinth labyrinth = currentLevel.getLabyrinth();
        switch (com) {
            case "u":
                if(labyrinth.getMapTile(player.getX(), player.getY() - 1).walkable())
                    player.moveUp();
                else
                    System.out.println("Не могу пройти.");
                break;
            case "d":
                if(labyrinth.getMapTile(player.getX(), player.getY() + 1).walkable())
                    player.moveDown();
                else
                    System.out.println("Не могу пройти.");
                break;
            case "l":
                if(labyrinth.getMapTile(player.getX() - 1, player.getY()).walkable())
                    player.moveLeft();
                else
                    System.out.println("Не могу пройти.");
                break;
            case "r":
                if(labyrinth.getMapTile(player.getX() + 1, player.getY()).walkable())
                    player.moveRight();
                else
                    System.out.println("Не могу пройти.");
                break;
            case "t":
                interactProcess();
                break;
            case "e":
                showInventary();
        }
    }

    private void showInventary() {
        //TODO: add drwing inventary
    }

    private void interactProcess() {
        Player player = currentLevel.getPlayer();
        for (Interact interact: currentLevel.getLabyrinth().getInteracts()) {
            if(player.getX() == interact.getX() && player.getY() == interact.getY()) {
                boolean interactResult = interact.interact();
                //if (!interactResult)
                System.out.println(interact.getLastMessage());
                return;
            }
        }
    }

    private boolean levelComplete() {
        return  currentLevel.getPlayer().getX() == currentLevel.getLabyrinth().getExitX() &&
                currentLevel.getPlayer().getY() == currentLevel.getLabyrinth().getExitY() &&
                currentLevel.getLabyrinth().canExit();
    }

    private boolean readLevels() {
        try(FileReader r = new FileReader("data/levels.txt")) {
            levels = new ArrayList<>();
            Scanner sc = new Scanner(r);
            while (sc.hasNext())
                levels.add(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
