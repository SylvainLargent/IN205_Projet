package ensta;

import ensta.controller.Game;
import ensta.model.*;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.util.Orientation;
import ensta.model.Coords;


public class TestBoard {

	public static void main(String args[]) {
        //new Game().init().run();
        Board board = new Board("Joueur 1");
        BattleShip ship1  = new BattleShip();
        Destroyer  ship2  = new Destroyer(Orientation.NORTH);
        Carrier    ship3  = new Carrier(Orientation.SOUTH);
        Submarine  ship4  = new Submarine(Orientation.WEST);

        Coords coords1 = new Coords(0,0);
        Coords coords2 = new Coords(0,2);
        Coords coords3 = new Coords(0,3);
        Coords coords4 = new Coords(6,8);
        Coords coordsHit = new Coords(4,0);
        Coords coordsSunk = new Coords(0,1);

        board.putShip(ship1, coords1);
        board.putShip(ship2, coords2);
        board.putShip(ship3, coords3);
        board.putShip(ship4, coords4);

        board.sendHit(coords2);
        board.sendHit(coordsHit);

        System.out.println(board.sendHit(coordsSunk) + " coulé");
        board.print();
        System.out.println(ship2.isSunk());        

    }

}
