package unsw.dungeon.Entity;

import java.util.List;

import unsw.dungeon.Dungeon;

public class Portal extends NotMoveable {

    int id;

    public Portal(int x, int y, Dungeon dungeon, boolean passable, int id) {
        super(x, y, dungeon, passable);
        this.id = id;
     }
    
     public int getId(){
         return this.id;
     }
     
     @Override
    public void interact(Player player){
        List<Entity> e0 = this.getDungeon().getEntityList();
        for (Entity thisthing : e0) {
			if (thisthing instanceof Portal){
                Portal copy = (Portal)thisthing;
                if (this.getId() == copy.getId() && !(this.getCoordinate().equals(copy.getCoordinate()))) {
                    player.setX(copy.getX());
                    player.setY(copy.getY());
                    // player.getCoordinate().setXY(copy.getX(), copy.getY());
                    return;
                }
            }
        }
    }
    }
    



