package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
		this.destroyedCount = 0;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();
			// TODO set ship orientation
			if(res.orientation.equals("east"))
				ship.setOrientation(Orientation.EAST);
			if(res.orientation.equals("west"))
				ship.setOrientation(Orientation.WEST);
			if(res.orientation.equals("south"))
				ship.setOrientation(Orientation.SOUTH);
			if(res.orientation.equals("north"))
				ship.setOrientation(Orientation.NORTH);
			//Récupérons les coordonnées du bateau
			Coords coords = new Coords(res.x,res.y);

			// TODO put ship at given position
			//Cas où, il n'est pas possible de placer un navire à ces coordonnées
			if(this.board.putShip(ship,coords) == false){
				System.out.println("Vous superposez des bateaux, ou votre bateau est hors des limites");
				System.out.println("Placez correctement votre bateau !");
				done = (i == 5);
			}
			// TODO when ship placement successful
			else{
				++i;
				done = (i == 5);
			}
			board.print();
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;
		Coords temp = new Coords(0,0);

		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			// TODO call sendHit on this.opponentBoard
			temp.setX(hitInput.x);
			temp.setY(hitInput.y);
			hit = this.opponentBoard.sendHit(temp);
			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			done = (hit != null);
			if(this.board.getHit(temp) != null){
				System.out.println("Frappe déjà réalisé, entrez de nouvelles coordonnées !");
				done = false;
			}
			// return hit is obvious. But how to return coords at the same time ?
			// Réponse : On modifie les coords prises en argument
		} while (!done);
		coords.setX(temp.getX());
		coords.setY(temp.getY());

		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
