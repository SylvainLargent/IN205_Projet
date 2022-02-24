package ensta.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ensta.ai.PlayerAI;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.util.ColorUtil;

public class Game2P {

	/*
	 * *** Constante
	 */
	public static final File SAVE_FILE = new File("savegame.dat");

	/*
	 * *** Attributs
	 */
	private Player player1;
	private Player player2;
	private Scanner sin;

	/*
	 * *** Constructeurs
	 */
	public Game2P() {
	}

	public Game2P init() {
		if (!loadSave()) {
			//Attention il faut une liste de taille 5, car putShips s'arrête après la mise en place de 5 bateaux
			//Il faut deux listes différentes pour que les bateaux ne partagent pas le même compteur de bateaux détruits
			List<AbstractShip> ships1 = createDefaultShips();
			List<AbstractShip> ships2 = createDefaultShips();

			// TODO init boards
			Board board1 = new Board("Sylvain");
			Board board2 = new Board("Gabriel");
			// TODO init this.player1 & this.player2
			this.player1 = new Player(board1, board2, ships1);
			this.player2 = new Player(board2, board1, ships2);
			// TODO place player ships
			this.player1.putShips();

            board2.print();

            System.out.println("Press enter so the next player can put his ships on the board");
            try{System.in.read();}
                    catch(Exception e){}
			this.player2.putShips();
            
            System.out.println("Press enter so the player 1 can play");
            try{System.in.read();}
                catch(Exception e){}
		}
		return this;
	}

	/*
	 * *** Méthodes
	 */
	public void run() {
		Coords coords = new Coords();
		Board b1 = player1.getBoard();
        Board b2 = player2.getBoard();

		Board empty_board = new Board("Empty", b1.getSize()); //Permet de cacher les deux écrans, d'un joueur par rapport à l'autre
		Hit hit;

		// main loop
		
		boolean done;

		do {
            //Affichage Nom du joueur et son board
		    System.out.println(player1.getBoard().getName());
            b1.print();
			hit = player1.sendHit(coords); // TODO player1 send a hit
			boolean strike = (hit != Hit.MISS); // TODO set this hit on his board (b1)
			b1.setHit(strike, coords);
			done = updateScore();
			b1.print();
			System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));

            if(!done && !strike){
                empty_board.print(); //Permet de cacher les deux écrans, d'un joueur par rapport à l'autre
                System.out.println("Press enter so the player 2 can play");
                try{System.in.read();}
                    catch(Exception e){}
            }

			// save();

			if (!done && !strike) {
				do {
                    //Affichage Nom du joueur et son board
		            System.out.println(player2.getBoard().getName());
                    System.out.println(makeHitMessage(true /* incoming hit*/, coords, hit));
                    b2.print();
					hit = player2.sendHit(coords); // TODO player2 send a hit.
					strike = (hit != Hit.MISS);
					b2.setHit(strike, coords);
                    System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));
					done = updateScore();

		
                    if(!done && !strike){
                        empty_board.print(); //Permet de cacher les deux écrans, d'un joueur par rapport à l'autre
                        System.out.println("Press enter so the player 1 can play");
                        try{System.in.read();}
                            catch(Exception e){}
                        System.out.println(makeHitMessage(true /*incoming hit*/, coords, hit));
                    }
                    

					if (!done) {
//						save();
					}
				} while (strike && !done);
			}

		} while (!done);

		SAVE_FILE.delete();
		System.out.println(String.format("%s a gagné !", player1.isLose() ? player2.getBoard().getName() : player1.getBoard().getName()));
		sin.close();
	}

	private void save() {
//		try {
//			// TODO bonus 2 : uncomment
//			// if (!SAVE_FILE.exists()) {
//			// SAVE_FILE.getAbsoluteFile().getParentFile().mkdirs();
//			// }
//
//			// TODO bonus 2 : serialize players
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private boolean loadSave() {
//		if (SAVE_FILE.exists()) {
//			try {
//				// TODO bonus 2 : deserialize players
//
//				return true;
//			} catch (IOException | ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		return false;
	}

	private boolean updateScore() {
		for (Player player : new Player[] { player1, player2 }) {
			int destroyed = 0;
			for (AbstractShip ship : player.getShips()) {
				if (ship.isSunk()) {
					destroyed++;
				}
			}

			player.setDestroyedCount(destroyed);
			player.setLose(destroyed == player.getShips().length);
			if (player.isLose()) {
				return true;
			}
		}
		return false;
	}

	private String makeHitMessage(boolean incoming, Coords coords, Hit hit) {
		String msg;
		ColorUtil.Color color = ColorUtil.Color.RESET;
		switch (hit) {
		case MISS:
			msg = hit.toString();
			break;
		case STRIKE:
			msg = hit.toString();
			color = ColorUtil.Color.RED;
			break;
		default:
			msg = hit.toString() + " coulé";
			color = ColorUtil.Color.RED;
		}
		msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords.getX())),
				(coords.getY()+1), msg);
		return ColorUtil.colorize(msg, color);
	}

	private static List<AbstractShip> createDefaultShips() {
		return Arrays.asList(new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new BattleShip(),
				new Carrier() });
	}
}