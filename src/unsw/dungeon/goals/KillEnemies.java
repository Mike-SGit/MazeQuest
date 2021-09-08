package unsw.dungeon.goals;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Enemy;



public class KillEnemies implements Goal {

    private Dungeon dungeon;
    private boolean isComplete;
    private String name;

    public KillEnemies(Dungeon dungeon){
        this.dungeon = dungeon;
        this.isComplete = false;
        this.name = "enemies";
    }


    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    @Override
    public void update() {
        boolean hasEnemy = false;
        if(dungeon.searchEntity(Enemy.class).size() > 0){
            hasEnemy = true;
        }
        if(hasEnemy == true){
            this.isComplete = false;
        }else{
            this.isComplete = true;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}