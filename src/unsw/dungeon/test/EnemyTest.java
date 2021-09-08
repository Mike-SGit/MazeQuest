package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Key;
import unsw.dungeon.Entity.InvincibilityPotion;

import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;

public class EnemyTest {
    

    @Test
    public void testBehaviour(){

        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 5, 5);  
        dungeon.setPlayer(p);
        dungeon.addEntity(p);
        Enemy e = new Enemy(6, 5, dungeon, true);
        dungeon.addEntity(e);
        
        e.moveDown();
        e.moveLeft();
        e.moveRight();
        e.moveUp();
        e.interact(p);
        Sword s1 = new Sword(1, 1, dungeon, true);
        p.addToInvesntory(s1);
        for(int i = 0; i < 6; i++){
            e.interact(p);
        }
        e.interact(p);

        Enemy e1 = new Enemy(6, 5, dungeon, true);
        dungeon.addEntity(e1);

        InvincibilityPotion po = new InvincibilityPotion(1, 1, dungeon, true, true, 5);
        po.interact(p);
        int a2 = po.getLastingTime();

        

        p.moveRight();
        // p1.moveLeft();





        


    
    
    }
}