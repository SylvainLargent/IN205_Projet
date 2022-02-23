package ensta.model.ship;
import ensta.util.Orientation;
import ensta.model.Coords;

public abstract class AbstractShip {
    private Orientation orientation; //Une orientation définie dans un enum
    private Coords coords;
    private int length;  //Taille du ship
    private String name; //Nom du navire
    private char label;  //Représentation des navires sur la grille, exemples : S,D,B,C

    //Constructeurs faits au préalable
    public AbstractShip(Orientation orientation_arg, Coords coords_arg, int length_arg, String name_arg){
        this.orientation = orientation_arg;
        this.coords = coords_arg;
        this.length = length_arg;
        this.name = name_arg;
    }

    public AbstractShip(int length_arg, String name_arg){
        this.length = length_arg;
        this.name = name_arg;
    }

    //Constructeur demandé à la question 2 !
    public AbstractShip(String name_arg, char label_arg, int length_arg, Orientation orientation_arg){
        this.length = length_arg;
        this.name = name_arg;
        this.orientation = orientation_arg;
        this.label = label_arg;
    }


    //ENCAPSULATION
    public void changeOrientation(Orientation orientation_arg){ //Mutateur de l'orientation
        this.orientation = orientation_arg;
    }

    public String getName(){
        return name;
    }
    
    public Orientation getOrientation(){
        return orientation;
    }

    public int getLength(){
        return length;
    }

    public char getLabel(){
        return label;
    }
    
    public Coords getCoords(){
        return coords;
    }


    public boolean isSunk(){
        return false;
    }

    //Implémentons un setter pour l'orientation !
    public void setOrientation(Orientation o){
        this.orientation = o;
    }


}
