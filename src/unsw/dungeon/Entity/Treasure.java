package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Treasure extends Item {

    String name;
    boolean isPickedUp;

    public Treasure(int x, int y, Dungeon dungeon, boolean passable, String name) {
        super(x, y, dungeon, passable);
        this.name = name;
        this.isPickedUp = false;
    }

    public String getName(){
        return this.name;
    }


    @Override
    public void interact(Player player){
        this.isPickedUp = true;
        player.inventory.add(this);
        this.getDungeon().hideItem(this);
        this.getDungeon().removeEntity(this);
    }

    




}