package unsw.dungeon.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import unsw.dungeon.Dungeon;

public class DexterityPotion extends InvincibilityPotion {
    

  

    public DexterityPotion(int x, int y, Dungeon dungeon, boolean passable, int lastingTime) {
        super(x, y, dungeon, passable, lastingTime);
    }

   

	public int getLastingTime() {
        return this.lastingTime;
    }

    @Override
    public void interact(Player player) {
        player.status = "dexterity";
        player.changeState(new Dexterity(player));
        this.getDungeon().hideItem(this);
        this.getDungeon().removeEntity(this);
        
    }
  

}
