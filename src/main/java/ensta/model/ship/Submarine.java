package ensta.model.ship;

import ensta.util.Orientation;

public class Submarine extends AbstractShip {
    //Constructeur par défaut !
    public Submarine(){
        super("Submarine", 'S', 3, Orientation.EAST); //super utilise le constructeur mère
    }
    //Constructeur Valué !
    public Submarine(Orientation orientation_arg){
        super("Submarine", 'S', 3, orientation_arg);
    }
}
