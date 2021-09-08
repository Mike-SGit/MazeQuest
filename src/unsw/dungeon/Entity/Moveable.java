package unsw.dungeon.Entity;

import java.util.List;

import unsw.dungeon.Coordinate;
import unsw.dungeon.Dungeon;

public abstract class Moveable extends Entity {
    private Coordinate recentcoord;


    public Moveable(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
	}
    
    public Moveable(int x, int y, Dungeon dungeon, boolean passable) {
		super(x, y, dungeon, passable);
	}

    public boolean isPathBlocked(int newX, int newY) {
		if (newX < 0 || newX > (this.getDungeon().getWidth() - 1) ||
        newY < 0 || newY > (this.getDungeon().getHeight() -1) ) {
			return true;
		}
		
		List <Entity> e = this.getDungeon().getEntitiesAtXY(newX, newY);
		for (Entity entity : e) {
			if (entity.getPassable() == false) {
				return true;
			}
			
		}
		return false;

    }
    

    

	public void moveUp() {
        boolean blocked = isPathBlocked(this.getY()+1, this.getX());
        //this.recentcoord.setXY(this.getX(), this.getCoordinate().getY());
		if (blocked == false){
            this.setY(getY()+1);
        }

    }
    
    public void moveLeft() {
        boolean blocked = isPathBlocked(this.getY(), this.getX()-1);
        this.recentcoord.setXY(this.getX(), this.getY());

		if (blocked == false){
            this.setX(getX()-1);
        }
    }
    
    public void moveRight() {
        boolean blocked = isPathBlocked(this.getY(), this.getX()+1);
        this.recentcoord.setXY(this.getX(), this.getY());

		if (blocked == false){
            this.setX(getX()+1);
        }
    }
    
    public void moveDown() {
        boolean blocked = isPathBlocked(this.getY()-1, this.getX());
        this.recentcoord.setXY(this.getX(), this.getY());
		if (blocked == false){
            this.setY(getY()-1);
        }
    }
    





}