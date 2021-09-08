package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Exit extends NotMoveable {

    boolean visibility;
    public Exit(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
        this.visibility = true;
     }

    public boolean getVisible(){
        return this.getVisible();
    }

    @Override
    public void interact(Player p) {
        this.getDungeon().trackGoal();
    }




}