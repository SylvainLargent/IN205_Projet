package ensta.model.ship;

public class ShipState {
    AbstractShip ship;
    boolean struck;

    public ShipState(){
        this.ship = null;
        this.struck = false;
    }


    public void addStrike(){
        if(this.struck == false)
            this.ship.addStrike();
    }

    public boolean isStruck(){
        return this.struck;
    }

    public String toString(){
        if(this.ship == null)
            return ".";
        else
            return this.ship.getLabel().toString();
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
