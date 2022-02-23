package ensta;

import ensta.ai.BattleShipsAI;
import ensta.controller.Game;
import ensta.model.*;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.util.Orientation;
import ensta.model.Coords;

public class TestGame {
    public static void main(String args[]) {
        Board board = new Board("Joueurs",11);
        board.print();
        AbstractShip [] ships_list = {new BattleShip(Orientation.NORTH), new Destroyer(Orientation.SOUTH), 
                                            new Submarine()};
        BattleShipsAI AI = new BattleShipsAI(board, board);
        int ships_destroyed = 0;
        
    }
}
