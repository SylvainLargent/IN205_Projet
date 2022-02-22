package ensta;

import ensta.controller.Game;
import ensta.model.*;

public class TestBoard {

	public static void main(String args[]) {
        //new Game().init().run();
        Board board = new Board("Joueur 1");
        board.print();
    }

}
