package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

public class Wall extends NotMoveable {


    public Wall(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
     }

    public Wall(int x, int y) {
        super(x, y);
    }


}