package unsw.dungeon.goals;

public interface Goal {
    
    public boolean isComplete();
    public void update();
    public String getName();
}