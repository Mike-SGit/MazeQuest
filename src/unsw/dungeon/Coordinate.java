package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Coordinate {
        // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    public Coordinate(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }

    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    public void setX(int x){
        this.x = new SimpleIntegerProperty(x);
    }

    public void setY(int y ){
        this.y = new SimpleIntegerProperty(y);
    }

    public boolean nextTo(Coordinate c){
        if(Math.abs(this.getX() - c.getX()) == 1 && this.getY() == c.getY()){
            return true;
        }
        if(Math.abs(this.getY() - c.getY()) == 1 && this.getX() == c.getX()){
            return true;
        }
        return false;
    }
   
    @Override
    public boolean equals(Object obj){
        if(obj == null || !obj.getClass().equals(this.getClass())){
            return false;
        }
        Coordinate c = (Coordinate)obj;
        if(c.getX() == this.getX() && c.getY() == this.getY()){
            return true;
        }
        return false;
    }
}