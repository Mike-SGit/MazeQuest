package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Switch extends NotMoveable {

    String status; // on, off
    int id;

    public Switch(int x, int y, Dungeon dungeon, boolean passable, int id) {
        super(x, y, dungeon, passable);
        this.status = "off";
        this.id = id;
  }

    public String getSwitchStatus() {
        return this.status;
    }

    public void setSwitchStatus(String newStatus){
        this.status = newStatus;
    }




}