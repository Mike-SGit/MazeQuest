package unsw.dungeon.goals;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Treasure;
public class CollectTreasure implements Goal{
    

    private Dungeon dungeon;
    private boolean isComplete;
    private String name;

    public CollectTreasure(Dungeon dungeon){
        this.dungeon = dungeon;
        this.isComplete = false;
        this.name = "treasure";
    }


    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    @Override
    public void update() {
        boolean hasTreasure = true;
        if(dungeon.searchEntity(Treasure.class).size() == 0){
             hasTreasure = false;
        }
        if(hasTreasure == true){
            this.isComplete = false;
        }else{
            this.isComplete = true;
        }
        // System.out.println("6666666666");
    }

    @Override
    public String getName() {
        return this.name;
    }
}