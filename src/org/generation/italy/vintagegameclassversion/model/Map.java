package org.generation.italy.vintagegameclassversion.model;

import java.util.ArrayList;
import java.util.StringJoiner;

public enum Map {
    MARKETPLACE("PHARMACY", "TEATRE", "MUSEUM", "CHURCH"), 
    PHARMACY("", "MARKETPLACE", "", "LIBRARY"), 
    MUSEUM("", "", "", "MARKETPLACE"), 
    CHURCH("LIBRARY", "SCHOOL", "MARKETPLACE", ""), 
    TEATRE("MARKETPLACE", "", "", "SCHOOL"), 
    SCHOOL("CHURCH", "", "TEATRE", ""), 
    LIBRARY("", "CHURCH", "PHARMACY", "");
    
    private ArrayList<String> objects;
    private String n;
    private String s;
    private String w;
    private String e;

    private Map(String n, String s, String w, String e) {
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        objects = new ArrayList<>();
    }

    static {
        MARKETPLACE.objects.add("pomodoro");
        PHARMACY.objects.add("test di gravidanza");
        MUSEUM.objects.add("vernice");
        CHURCH.objects.add("rosario");
        TEATRE.objects.add("maschera");
        SCHOOL.objects.add("righello");
        LIBRARY.objects.add("libro");
    }

    public Map move(String direction) {
        if(direction.equals("n") && !this.getN().equals("")) {
            for (Map map : Map.values()) {
                if(this.getN().equals(map.toString())) {
                    return map;
                }
            }
        } else if(direction.equals("s") && !this.getS().equals("")) {
            for (Map map : Map.values()) {
                if(this.getS().equals(map.toString())) {
                    return map;
                }    
            }
        } else if(direction.equals("w") && !this.getW().equals("")) {
            for (Map map : Map.values()) {
                if(this.getW().equals(map.toString())) {
                    return map;
                }
            }
        } else if(direction.equals("e") && !this.getE().equals("")) {
            for (Map map : Map.values()) {
                if(this.getE().equals(map.toString())) {
                    return map;
                }   
            }
        }
        return this;
    }

    public boolean addObject(String objectName) {
        return objects.add(objectName);
    }

    public boolean removeObject(String objectName) {
        return objects.remove(objectName);
    }

    public String getRoomDescription() {
        StringBuilder sb = new StringBuilder("Sei in ");
        sb.append(super.toString()).append("\n");
        if(objects.isEmpty()) {
            sb.append("Non esistono oggetti in questa stanza.").append("\n");
        } else {
            StringJoiner sj = new StringJoiner(",","Inventory: [", "]");
            for (String object : objects) {
                sj.add(object);
            }
            sb.append(sj.toString()).append("\n");
        }
        sb.append(getExits());
        return sb.toString();
    }

    private String getExits() {
        StringBuilder sb = new StringBuilder();
        for (Map map : Map.values()) {
            if(this.getN().equals(map.toString())) {
                sb.append("Puoi andare a Nord in ").append(this.getN()).append("\n");
            } else if(this.getS().equals(map.toString())) {
                sb.append("Puoi andare a Sud in ").append(this.getS()).append("\n");
            } else if(this.getW().equals(map.toString())) {
                sb.append("Puoi andare a Ovest in ").append(this.getW()).append("\n");
            } else if(this.getE().equals(map.toString())) {
                sb.append("Puoi andare a Est in ").append(this.getE()).append("\n");
            }
        }
        return sb.toString();
    }

    public String getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public String getW() {
        return w;
    }

    public String getE() {
        return e;
    }
}