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
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;

public class BoulderTest {
    

    @Test
    public void testBehaviour(){

        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 5, 5);  
        dungeon.setPlayer(p);
        dungeon.addEntity(p);
        Boulder b = new Boulder(6, 5, dungeon, false);
        dungeon.addEntity(b);


        p.moveRight();
        assertEquals(b.getX(), 7);

        
        Boulder b1 = new Boulder(5, 5, dungeon, false);
        dungeon.addEntity(b1);
        p.moveLeft();
        assertEquals(b1.getX(), 4);


        Boulder b2 = new Boulder(5, 6, dungeon, false);
        dungeon.addEntity(b2);
        p.moveUp();
        assertEquals(b2.getY(), 7);

        Boulder b3 = new Boulder(5, 5, dungeon, false);
        dungeon.addEntity(b3);
        p.moveDown();
        assertEquals(b3.getY(), 4);

        Switch s1 = new Switch(5, 4, dungeon, true, "off", 3);
        dungeon.addEntity(s1);
        // System.out.println(s1.getSwitchStatus());
        b3.activateSwitches();
        // System.out.println(s1.getSwitchStatus());
        b3.deactivateSwitches();
        // System.out.println(s1.getSwitchStatus());

        Boulder b4 = new Boulder(5, 3, dungeon, false);
        dungeon.addEntity(b4);
        p.moveDown();
        assertEquals(b4.getY(), 3);



        // Boulder b1 = new Boulder(8, 5, dungeon, false);
        // p.moveLeft();
  

        // Player p1 = new Player(dungeon, 10, 5);  
        // Boulder b2 = new Boulder(11, 5, dungeon, false);
        // Switch s1 = new Switch(12, 5, dungeon, true, "off", 1);
        // p1.moveLeft();
 
        // p1.moveLeft();





        


    
    
    }
}