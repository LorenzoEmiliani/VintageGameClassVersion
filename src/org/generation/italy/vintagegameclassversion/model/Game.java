package org.generation.italy.vintagegameclassversion.model;

import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void instruction() {
        System.out.println("Ciao " + player.getName() + " queste sono le istruzioni del gioco:");
        System.out.println("Inserisci la direzione dove vuoi andare (n,s,w,e) e premi enter per muoverti.");
        System.out.println("Scrivi pick e il nome dell'oggetto e premi enter per prendere un oggetto presente nella mappa.");
        System.out.println("Scrivi drop e il nome dell'oggetto e premi enter per lasciare un oggetto del tuo inventario sulla mappa");
        System.out.println("Scrivi inv e premi enter per vedere gli oggetti del tuo inventario.");
        System.out.println("Scrivi exit e premi enter per uscire dal gioco.");
    }

    public void announceMap() {
        System.out.println(player.getActualMap().getRoomDescription());
    }

    public void start() {
        System.out.println("Ciao come ti chiami?");
        player = new Player(scanner.nextLine());
        instruction();
        while(true) {
            announceMap();
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            if(parts[0].equals("exit")) {
                break;
            }
            String result = player.play(parts);
            System.out.println(result);
        }
        System.out.println("Grazie per aver giocato.");
    }
}
