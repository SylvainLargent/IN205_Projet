package ensta.model.ship;

import ensta.util.Orientation;

public class Carrier extends AbstractShip {
  //Constructeur par défaut !
    public Carrier(){
      super("Carrier", 'C', 5, Orientation.EAST); //super utilise le constructeur mère
  }
  //Constructeur Valué !
  public Carrier(Orientation orientation_arg){
      super("Carrier", 'C', 5, orientation_arg);
  }
}
