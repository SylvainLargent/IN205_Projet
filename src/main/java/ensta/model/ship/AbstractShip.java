package ensta.model.ship;
import ensta.util.Orientation;

import java.io.Serializable;

import ensta.model.Coords;

public abstract class AbstractShip implements Serializable {
    private Orientation orientation; //Une orientation définie dans un enum
    private Coords coords;
    private int length;  //Taille du ship
    private String name; //Nom du navire
    private Character label;  //Représentation des navires sur la grille, exemples : S,D,B,C
    private int strikeCount; //Il faudra penser à le valuer dans les constructeurs, a priori à 0, ET à l'encapsulation

    //Constructeurs faits au préalable
    public AbstractShip(Orientation orientation_arg, Coords coords_arg, int length_arg, String name_arg){
        this.orientation = orientation_arg;
        this.coords = coords_arg;
        this.length = length_arg;
        this.name = name_arg;
        this.strikeCount = 0;
    }

    public AbstractShip(int length_arg, String name_arg){
        this.length = length_arg;
        this.name = name_arg;
        this.strikeCount = 0;
    }

    //Constructeur demandé à la question 2 !
    public AbstractShip(String name_arg, Character label_arg, int length_arg, Orientation orientation_arg){
        this.length = length_arg;
        this.name = name_arg;
        this.orientation = orientation_arg;
        this.label = label_arg;
        this.strikeCount = 0;
    }

    //Exercice 5 !
    public void addStrike(){
        this.strikeCount ++;
    }

    public boolean isSunk(){
        return (this.strikeCount == this.length);
    }

    //ENCAPSULATION
    public void changeOrientation(Orientation orientation_arg){ //Mutateur de l'orientation
        this.orientation = orientation_arg;
    }

    public String getName(){
        return this.name;
    }
    
    public Orientation getOrientation(){
        return this.orientation;
    }

    public int getLength(){
        return this.length;
    }

    public Character getLabel(){
        return this.label;
    }
    
    public Coords getCoords(){
        return this.coords;
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

    //Implémentons un setter pour l'orientation !
    public void setOrientation(Orientation o){
        this.orientation = o;
    }


}
