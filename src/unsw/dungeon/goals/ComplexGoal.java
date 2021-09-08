package unsw.dungeon.goals;

import java.util.ArrayList;
import java.util.List;

import unsw.dungeon.Dungeon;
import unsw.dungeon.DungeonLoader;

public class ComplexGoal implements Goal {
    private Dungeon dungeon;
    private List<Goal> goals;
    private String logic;
    private boolean isComplete;

    public ComplexGoal(Dungeon dungeon, String logic){
        this.dungeon = dungeon;
        this.logic = logic;
        this.goals = new ArrayList<Goal>();
        this.isComplete = false;
    }

    public List<Goal> getGoalList(){
        return this.goals;
    }

    @Override
    public boolean isComplete() {
        if(logic == "AND"){
            for(Goal g : goals){
                if(g.isComplete() == false){
                    return false;
                }
            }
            return true;
        }else{
            for(Goal g : goals){
                if(g.isComplete() == true){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void update() {
        for(Goal g : getGoalList()){
            System.out.println("pppp from update()");
            g.update();
        }
        if(this.isComplete() == true){
            this.isComplete = true;
        }else{
            this.isComplete = false;
        }

    }

    @Override
    public String getName() {
        return this.logic;
    }
    
    public void addGoal(Goal g){
        System.out.println("from addgoal");
        this.goals.add(g);
    }

    public void removeGoal(Goal g){
        this.goals.remove(g);
    }
}