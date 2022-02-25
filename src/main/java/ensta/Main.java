package ensta;

import java.util.Scanner;

import ensta.controller.Game;
import ensta.controller.Game2P;

import ensta.model.*;

public class Main {

	public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String coord;
        System.out.println("Tapez 1 pour jouer une nouvelle partie contre une IA");
        System.out.println("Tapez 2 pour jouer une nouvelle partie contre un autre joueur");
        System.out.println("Tapez 3 pour reprendre la partie existante (Si elle était contre une IA)");
        System.out.println("Tapez 4 pour reprendre la partie existante (Si elle était contre un autre joueur)");
        coord = scanner.nextLine().toLowerCase();

        boolean done1 = coord.equals("1");
        boolean done2 = coord.equals("2");
        boolean done3 = coord.equals("3");
        //boolean done4 = coord.equals("4");

        if(done1){
            new Game().init(false).run();
        }
        else if (done2){
            new Game2P().init(false).run();
        }
        else if (done3){
            new Game().init(true).run();
        }
        else{
            new Game2P().init(true).run();
        }
        scanner.close();
    }

}
