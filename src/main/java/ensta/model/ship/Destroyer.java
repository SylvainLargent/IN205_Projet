package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip{
    //Constructeur par défaut !
    public Destroyer(){
        super("Destroyer", 'D', 2, Orientation.EAST); //super utilise le constructeur mère
    }
    //Constructeur Valué !
    public Destroyer(Orientation orientation_arg){
        super("Destroyer", 'D', 2, orientation_arg);
    }
}
