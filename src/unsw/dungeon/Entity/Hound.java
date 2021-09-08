package unsw.dungeon.Entity;
import unsw.dungeon.Dungeon;


public class Hound extends Enemy {

    public String status;
    public String behaviourStatus; //Toward || Away
    private String lastMove;
    
    public Hound(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
        this.status = "alive";
        this.behaviourStatus = "aggressive";
        this.lastMove = "null";
    }
    
}