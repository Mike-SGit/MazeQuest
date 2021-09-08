package unsw.dungeon.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import unsw.dungeon.Dungeon;

public class InvincibilityPotion extends Item {

    int lastingTime;

    public InvincibilityPotion(int x, int y, Dungeon dungeon, boolean passable,int lastingTime) {
        super(x, y, dungeon, passable);
        this.lastingTime = lastingTime;
    }

   

	public int getLastingTime() {
        return this.lastingTime;
    }

    @Override
    public void interact(Player player) {
        player.status = "invincible";
        player.changeState(new Invincible(player));
        this.getDungeon().hideItem(this);
        this.getDungeon().removeEntity(this);



        List<Entity> a = this.getDungeon().getEntityList();
        // System.out.println(a.toString());
        for(Entity e : a) {
            if (e instanceof Enemy){
                Enemy e1 = (Enemy)e;
                e1.setBehaviour("flee");
                System.out.println("enemies are fleeing");
            }
        }
    }
    
  


}