package ensta.model.ship;
import ensta.util.Orientation;
import ensta.model.Coords;

public abstract class AbstractShip {
    private Orientation orientation;
    private Coords coords;
    private int length;
    private String name;

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

    public String getName(){
        return name;
    }
    
    public Orientation getOrientation(){
        return orientation;
    }

    public int getLength(){
        return length;
    }

    public boolean isSunk(){
        return false;
    }
}
