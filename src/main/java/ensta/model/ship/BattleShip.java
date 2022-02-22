package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip {
    //Constructeur par défaut !
    public BattleShip(){
        super("BattleShip", 'B', 4, Orientation.EAST);
    }
    //Constructeur Valué !
    public BattleShip(Orientation orientation_arg){
        super("BattleShip", 'B', 4, orientation_arg);
    }
}