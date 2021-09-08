package unsw.dungeon.goals;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Exit;


public class GetExit implements Goal {

    private Dungeon dungeon;
    private boolean isComplete;
    private String name;

    public GetExit(Dungeon dungeon){
        this.dungeon = dungeon;
        this.isComplete = false;
        this.name = "exit";
    }


    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    @Override
    public void update() {
        boolean atExit  = false;
        for(Entity e : dungeon.searchEntity(Exit.class)){
            if(e.getCoordinate().equals(dungeon.getPlayerPosition())){
                atExit = true;
            }
        }
        if(atExit == true){
            this.isComplete = true;
        }else{
            this.isComplete = false;
        }

    }

    @Override
    public String getName() {
        return this.name;
    }
    
}