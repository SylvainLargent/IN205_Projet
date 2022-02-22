package ensta;

import ensta.controller.Game;
import ensta.model.*;

public class Main {

	public static void main(String args[]) {
        //new Game().init().run();
        Board board = new Board("Joueur 1",11);
        board.print();
    }

}
