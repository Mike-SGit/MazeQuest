package unsw.dungeon.Entity;

import java.util.ArrayList;

import unsw.dungeon.Dungeon;

public class Door extends NotMoveable {

    private int id;
    private String status; //closed, open

    public Door(int x, int y, Dungeon dungeon, boolean passable, int id) {
        super(x, y, dungeon, passable);
        this.id = id;
        this.status = "closed";
     }

    public int getId(){
        return this.id;        
    }

    public String getDoorStatus(){
        return this.status;
    }

    public void setDoorStatus(String newStatus) {
        this.status = newStatus;
    }

    public void open( ) {
        this.passable = true;
        this.getDungeon().hideItem(this);
    }
    
    @Override
    public void interact(Player p) {
        if (this.getDoorStatus() == "open") return;

        ArrayList<Item> i0 = p.getPlayerInventory();
        for (Item thisItem : i0) {
			if (thisItem instanceof Key){
                Key k = (Key)thisItem;
                if (k.getId() == this.getId()){
                    this.setDoorStatus("open");
                    p.removeFromInvesntory(k);
                    return;
                }
            }
        }
    }



}