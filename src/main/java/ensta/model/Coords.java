package ensta.model;
import java.util.Random;

public class Coords {
    private int x;
    private int y;


    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coords(Coords coords){
        this.x = coords.x;
        this.y = coords.y;
    }

    public Coords(){}

    

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }
 
    public void setY(int y){
        this.y = y;
    }

    public void setCoords(Coords coords){
        this.x = coords.getX();
        this.y = coords.getY();
    }

    public boolean isInBoard(int size){
        return (this.x < size && this.y < size);
    }

    public static Coords randomCoords(int random){
        Coords coords = new Coords(1,2);
        return coords;
    }

}
