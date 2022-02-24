package ensta.model.ship;

import java.io.Serializable;

import ensta.util.ColorUtil;

public class ShipState implements Serializable{
    AbstractShip ship;
    boolean struck;

    public ShipState(){
        this.ship = null;
        this.struck = false;
    }

    public ShipState(AbstractShip ship){
        this.ship = ship;
        this.struck = false;
    }


    public void addStrike(){
        if(this.struck == false){
            this.ship.addStrike();
            this.struck = true;
        }
    }

    public boolean isStruck(){
        return this.struck;
    }

    public String toString(){
        if(this.ship == null)
            return ".";
        else if(this.struck == false)
            return this.ship.getLabel().toString(); //Label is a Character
        else
            return ColorUtil.colorize(this.ship.getLabel().toString(), ColorUtil.Color.RED);
    }

    public boolean isSunk(){
        return this.ship.isSunk();
    }

    public AbstractShip getShip(){
        return this.ship;
    }

    public void setShip(AbstractShip ship_arg){
        this.ship = ship_arg;
    }
}
