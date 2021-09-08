package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public abstract class NotMoveable extends Entity {
    
    public NotMoveable(int x, int y, Dungeon dungeon, boolean passable) {
	      super(x, y, dungeon, passable);
    }

    public NotMoveable(int x, int y) {
        super(x, y);
    }
    

    

}



