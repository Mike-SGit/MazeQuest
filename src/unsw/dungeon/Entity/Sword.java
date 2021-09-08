package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Sword extends Item {

    private int durability;


    public Sword(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
        this.durability = 5;
    }

    public int getDurability(){
        return this.durability;
    }

    public void loseDurability(){
        this.durability = this.durability - 1;
    }


    @Override
    public void interact(Player player){
        System.out.print("in sword interact..");
        if (player.checkInventory(this)){
        System.out.print("already have..");
            return;
        } else {
            player.addToInvesntory(this);
         
            this.getDungeon().hideItem(this);
            this.getDungeon().removeEntity(this);

            System.out.print("we got a sword!");
        }
    }

    




}