package project.impl;

import project.base.Inventary;
import project.base.InventaryItem;

import java.util.ArrayList;

public class SimpleInventary implements Inventary {
    private ArrayList<InventaryItem> items;

    @Override
    public void addToInventary(InventaryItem item) {
        items.add(item);
    }

    @Override
    public String drawInventary() {
        String s = "";
        for (int i =0; i < items.size(); i++) {
            s+= i + "->" + items.get(i).getName()+"\n";
        }
        return s;
    }
}
