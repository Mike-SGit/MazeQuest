package unsw.dungeon.Entity;
import unsw.dungeon.Dungeon;

import java.util.ArrayList;
import java.util.List;

import unsw.dungeon.Dungeon;

public class Boulder extends Moveable {


    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Boulder(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
    }
    //public List<Entity> getEntities(Coordinate coordinate, Class<?> cls){
    public void activateSwitches(){
        List<Entity> a0 = this.getDungeon().getEntities(this.getCoordinate(), Switch.class);
        for ( Entity thisSwitch : a0) {
            Switch newSwitch = (Switch)thisSwitch;
			newSwitch.setSwitchStatus("on");
        }
    }

    public void deactivateSwitches(){
        List<Entity> a0 = this.getDungeon().getEntities(this.getCoordinate(), Switch.class);
        for ( Entity thisSwitch : a0) {
            Switch newSwitch = (Switch)thisSwitch;
			newSwitch.setSwitchStatus("off");
        }
        

    }

    


  

    

    

}


