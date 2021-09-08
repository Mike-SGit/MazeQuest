package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Key extends Item {


    int id;
    
    public Key(int x, int y, Dungeon dungeon, Boolean passable,int id) {
        super(x, y, dungeon, passable);
        this.id = id;
    }



    public int getId(){
        return this.id;
    }

    @Override
    public void interact(Player player){
        if (player.inventory.contains(this)){
            return;
        } else {
            player.inventory.add(this);
            this.getDungeon().removeEntity(this);
            this.getDungeon().hideItem(this);

        }
    }

    




}