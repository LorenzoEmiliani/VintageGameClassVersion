package org.generation.italy.vintagegameclassversion.model;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Player {
    private String name;
    private ArrayList<String> inventary = new ArrayList<>();
    private Map actualMap;

    public Player(String name) {
        this.name = name;
        actualMap = Map.MARKETPLACE;
    }

    public String play(String[] commandParts) {
        return switch(commandParts[0]) {
            case "n", "s", "w", "e" -> this.move(commandParts[0]);
            case "inv" -> this.inv();
            case "pick" -> this.pick(commandParts[1]);
            case "drop" -> this.drop(commandParts[1]);
            default -> "Comando non riconosciuto.";
        };
    } 
    
    private String pick(String object) {
        if(actualMap.removeObject(object)) {
            inventary.add(object);
            return String.format("Hai raccolto un %s", object);
        }
        return String.format("Non c'è nessun %s in qeusta stanza.", object);
    }
    
    private String drop(String object) {
        if(inventary.remove(object)) {
            actualMap.addObject(object);
            return String.format("Hai lasciato un %s", object);
        }
        return String.format("Non hai un %s nel tuo inventario.", object);
    }

    private String move(String direction) {
        Map newMap = actualMap.move(direction);
        if(newMap.equals(actualMap)) {
            return "Non puoi andare in quella direzione.";
        }
        actualMap = newMap;
        return String.format("Sei andato a %s", direction);
    }

    private String inv() {
        if(inventary.isEmpty()) {
            return "Non ci sono oggetti nel tuo inventario."; 
        }
        StringJoiner sj = new StringJoiner(",","Inventory: [", "]");
        for (String object : inventary) {
            sj.add(object);
        }
        return sj.toString();
    }

    public Map getActualMap() {
        return actualMap;
    }

    public void setActualMap(Map actualMap) {
        this.actualMap = actualMap;
    }

    public String getName() {
        return name;
    }
}

