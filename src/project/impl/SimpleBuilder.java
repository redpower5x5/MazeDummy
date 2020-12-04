package project.impl;

import project.base.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SimpleBuilder implements Builder {
//    private char[] readSymbols() {
//        char[] symbols = new char[4];
//        try (FileReader r = new FileReader("data/" + levelName + "/map.txt")) {
//            Scanner sc = new Scanner(r);
//
//            String str = sc.nextLine();
//            symbols[0] = str.charAt(str.length() - 1);
//            str = sc.nextLine();
//            symbols[1] = str.charAt(str.length() - 1);
//            str = sc.nextLine();
//            symbols[2] = str.charAt(str.length() - 1);
//            str = sc.nextLine();
//            symbols[3] = str.charAt(str.length() - 1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return symbols;
//    }

//    private ArrayList<ArrayList<Character>> readMap() {
//        ArrayList<ArrayList<Character>> map = new ArrayList<>();
//        try (FileReader r = new FileReader("data/" + levelName + "/map.txt")) {
//            Scanner sc = new Scanner(r);
//
//            sc.nextLine();
//            sc.nextLine();
//            sc.nextLine();
//            sc.nextLine();
//            while (sc.hasNext()) {
//                ArrayList<Character> lineChars = new ArrayList<>();
//                String line = sc.nextLine();
//                for(int i = 0; i < line.length(); ++i)
//                    lineChars.add(line.charAt(i));
//                map.add(lineChars);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return map;
//    }

    private Player readPlayer(String levelName) {
        Player person;
        try (FileReader r = new FileReader("data/" + levelName + "/person_conf.txt")) {
            Scanner sc = new Scanner(r);
            int x = 0, y = 0;
            char s = 0;
            int layer = 0;
            String str = sc.next();
            x = sc.nextInt();
            str = sc.next();
            y = sc.nextInt();
            str = sc.next();
            s = sc.next().charAt(0);
            str = sc.next();
            layer = sc.nextInt();

            person = new SimplePlayer(x, y, s, layer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return person;
    }

    private HashMap<Character, Boolean> readSymbols(Scanner scanner) {
        int cnt = scanner.nextInt();
        HashMap<Character, Boolean> result = new HashMap<>();
        for (int i = 0; i < cnt; ++i) {
            scanner.next();
            Character key = scanner.next().charAt(0);
            Boolean value = scanner.next().charAt(0) == '+';
            result.put(key, value);
        }
        return result;
    }

    private ArrayList<ArrayList<MapTile>> readMap(Scanner sc, HashMap<Character, Boolean> tileTypes) {
        ArrayList<ArrayList<MapTile>> map = new ArrayList<>();

        int y = 0;
        while (sc.hasNext()) {
            if(y == 8)
                System.out.println();
            ArrayList<MapTile> lineChars = new ArrayList<>();
            String line = sc.nextLine();
            for(int x = 0; x < line.length(); ++x)
                lineChars.add(
                        new SimpleMapTile(
                                x,
                                y,
                                line.charAt(x),
                                SimpleLabyrinth.LABYRINTH_LAYER,
                                tileTypes.get(line.charAt(x)))
                );
            map.add(lineChars);
            ++y;
        }
        return map;
    }

    private Labyrinth readLabyrinth(String levelName) {
        ArrayList<ArrayList<MapTile>> map;
        int eX = 0;
        int eY = 0;
        try (FileReader r = new FileReader("data/" + levelName + "/map.txt")) {
            Scanner sc = new Scanner(r);
            sc.next();
            eX = sc.nextInt();
            eY = sc.nextInt();

            HashMap<Character, Boolean> tileTypes = readSymbols(sc);
            sc.nextLine();
            map = readMap(sc, tileTypes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        ArrayList<Lever> levers = readLevers(levelName);
        ArrayList<Decoration> decorations = readDecorations(levelName);
        ArrayList<Key> keys = readKeys(levelName);
        ArrayList<Door> doors = readDoors(levelName);
        return new SimpleLabyrinth(levers, decorations, keys, doors, map, eX, eY);
    }

    private ArrayList<Door> readDoors(String levelName) {
        ArrayList<Door> doors = new ArrayList<>();
        try (FileReader r = new FileReader("data/" + levelName + "/doors.txt")) {
            Scanner sc =  new Scanner(r);
            while (sc.hasNext()) {
                doors.add(
                        new SimpleDoor(
                                sc.next().charAt(0),
                                sc.next().charAt(0),
                                sc.next().charAt(0),
                                sc.nextInt(),
                                sc.nextInt(),
                                sc.nextInt()
                        )

                );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return doors;
    }

    private ArrayList<Key> readKeys(String levelName) {
        return null;
    }

    private ArrayList<Decoration> readDecorations(String levelName) {
        ArrayList<Decoration> decorations = new ArrayList<>();
        try (FileReader r = new FileReader("data/" + levelName + "/decorations.txt")) {
            Scanner sc = new Scanner(r);
            while (sc.hasNext()) {
                decorations.add(
                        new Decoration(
                                sc.nextInt(),
                                sc.nextInt(),
                                sc.nextInt(),
                                sc.next().toCharArray()
                        )
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return decorations;
    }

    private ArrayList<Lever> readLevers(String levelName) {
        ArrayList<Lever> levers = new ArrayList<>();
        try (FileReader r = new FileReader("data/" + levelName + "/levers.txt")) {
            Scanner sc = new Scanner(r);
            while (sc.hasNext()) {
                levers.add(
                        new SimpleLever(
                                sc.next().charAt(0),
                                sc.next().charAt(0),
                                sc.nextInt(),
                                sc.nextInt(),
                                sc.nextInt()
                        )
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return levers;
    }

    @Override
    public GameStage build(String levelName) {
        Labyrinth labyrinth = readLabyrinth(levelName);

        Player player = readPlayer(levelName);

        return new SimpleGameStage(labyrinth, player);
    }
}
