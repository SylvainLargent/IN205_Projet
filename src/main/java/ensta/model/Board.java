package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.model.Hit;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	private String nom;
	private char[][] navires;
	private boolean[][] frappes;

	public Board() {
	}

	private void board_init(){  //On encapsule le board, pour que sa taille ne soit plus modifiable
		for(int i=0; i < this.size; ++i){
			for(int j = 0; j < this.size; ++j){
				this.navires[i][j] = '.';
				this.frappes[i][j] = false;
			}
		}
	}

	public Board(String name, int size){
		this.size = size;
		this.navires = new char[size][size];
		this.frappes = new boolean[size][size];
		board_init();
	}

	public Board(String name){
		this.size = DEFAULT_SIZE;
		this.navires = new char[DEFAULT_SIZE][DEFAULT_SIZE];
		this.frappes = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
		board_init();
	}


	public void print() {
		//Première ligne 
		System.out.print(" Navires:"); //Char de taille 8
		int m = 0;
		while(m < 2*size - 8){    //arrivé à la fin du premier tableau
			System.out.print(" "); //Blanc entre les deux titres
			m++;
		}
		System.out.print("       "); //Blanc entre les deux tableaux
		System.out.println("Frappes:"); //Retour à la ligne tranquillement



		//Tracé de la première ligne  des tableaux(Légendes des colonnes)
		int l= 0;
		while(l<2){
			System.out.print(" "); //Espace avant la légende des colonnes
			if(this.size > 9){
				System.out.print(" "); //Cas où le board est trop grand
				System.out.print(" "); //Cas où le board est trop grand								
			}
			char s = 'A';
			for(int k = 0; k <size; ++k){
				System.out.print(s);
				System.out.print(" "); //Espace entre les colonnes
				s++;
			}
			l++;
			System.out.print("    "); //Blanc entre les deux tableaux
		}

		System.out.print("\n");  //Saut de ligne 

		//Tracé des Tableaux
		for(int i=0; i < size;++i){  // Parcours les lignes
			l = 0; 					 //Numéro du tableau 
			while(l<2){
				for(int j = 0; j < (size + 1); ++j){  // Parcours les colonnes (2 fois pour les deux tableaux)
					if(j > 0){ // Tracé des tableaux
						if(l==0){ //Tracé du tableau navires
							System.out.print(navires[i][j-1]);  
							System.out.print(" "); //Espace entre les colonnes
						}
						else{  //Tracé du second tableau frappes
							if(frappes[i][j-1] == false){
								System.out.print('.');
							}
							else{
								System.out.print('X');
							}
							System.out.print(" "); //Espace entre les colonnes
						}
					}
					else{ 						//Tracé de la légende des Lignes
						if(this.size > 9){
							if(i < 9)
								System.out.print(" "); 	//Espace pour les boards plus grands que 10
						}
						System.out.print(i+1);	 //Numero de la ligne
						System.out.print(" "); 	//Espace après la première colonne
					}
				}
				System.out.print("    "); //Blanc entre les deux tableaux
				l++;
			}
			System.out.println(); //Saut de ligne, nouvelle ligne
		}
	}

	//La description de ces fonctions est donnée dans l'interface IBoard.java
	public boolean putShip(AbstractShip ship, Coords coords){
		//On récupère d'abord toutes les variables utiles
		Orientation o = ship.getOrientation();

		//dx correspond au pas par rapport aux colonnes
		//dy correspond au pas par rapport aux lignes
		int dx = 0, dy = 0;


		//Vérifions que nous pouvons placer le bateau
		if(this.canPutShip(ship, coords)==false){
			return false;
		}
		//Reprenons le squelette de canPutShip
		if (o == Orientation.EAST) {
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			dy = 1;
		} else if (o == Orientation.NORTH) {
			dy = -1;
		} else if (o == Orientation.WEST) {
			dx = -1;
		}
		//On modifie le board
		for (int i = 0; i < ship.getLength(); ++i) {
			navires[coords.getY() + i*dy][coords.getX() + i*dx] = ship.getLabel();
		}
		return true;
	}

	public boolean hasShip(Coords coords){
		//On vérifie qu'il n'y a pas déjà un navire sur le board à ces coordonnées
		if(this.navires[coords.getY()][coords.getX()] != '.')
			return true;
		else
			return false;
	}	

	public void setHit(boolean hit, Coords coords){
		//On set la frappe aux coordonnées correspondantes
		frappes[coords.getY()][coords.getX()] = hit;
	}

	public int getSize(){ //Encapsulation
		return size;
	}

	public Boolean getHit(Coords coords){
		return frappes[coords.getY()][coords.getX()];
	} 

	public Hit sendHit(Coords res){
		Hit missile = Hit.MISS;
		return missile;
	}


	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}
}
