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
        System.out.println(board.getSize());
        board.print();
        //Un simple Array
        AbstractShip [] ships_list = {new Destroyer(), new BattleShip()};
        BattleShipsAI ai = new BattleShipsAI(board, board);
        ai.putShips(ships_list);
        board.print();
        int ships_destroyed = 0;
        Coords coords;
        Hit hit;
        while(ships_destroyed < ships_list.length){
            coords = Coords.randomCoords(board.getSize());
            hit = ai.sendHit(coords);
            System.out.println(hit + " en " + coords);
            if(hit != Hit.MISS && hit != Hit.STRIKE){
                ++ships_destroyed;
            }
            board.print();
            sleep(10);
        }
        
    }


    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
