package project.impl;

import project.base.GameStage;
import project.base.Inventary;
import project.base.InventaryItem;

import java.util.ArrayList;

public class SimpleInventary implements Inventary {
    private ArrayList<InventaryItem> items;

    public SimpleInventary() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addToInventary(InventaryItem item) {
        items.add(item);
    }

    @Override
    public String drawInventary() {
        String s = "Выберите номер элемента для использования";
        s+="0->Выход\n";
        for (int i =0; i < items.size(); i++) {
            s+= i+1 + "->" + items.get(i).getName()+"\n";
        }
        return s;
    }

    @Override
    public void selectAndUseItemAt(int i, GameStage gameStage) {
        if(i!=-1) {
            try {
                if (items.get(i).performAction(gameStage)) items.remove(i);
            } catch (Exception e) {
                System.out.println("Введите корректный номер существующего элемента в инвентаре");
            }
        }
    }
}
