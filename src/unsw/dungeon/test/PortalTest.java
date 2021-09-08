package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unsw.dungeon.Dungeon;

import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Portal;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Wall;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Key;
import unsw.dungeon.Entity.InvincibilityPotion;



public class PortalTest {
    
    @Test
    public void testBehaviour(){

        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 5, 5);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);

        Portal po1 = new Portal(1, 1, dungeon, true, 5);
        Portal po2 = new Portal(20, 20, dungeon, true, 5);
        dungeon.addEntity(po2);
        dungeon.addEntity(po1);

        po1.interact(p);

        // System.out.println(p.getCoordinate().getX() + " " + p.getCoordinate().getY());
    
        Sword s1 = new Sword(21, 20, dungeon, true);
        Sword s2 = new Sword(22, 20, dungeon, true);
        Sword s3 = new Sword(23, 20, dungeon, true);
        Sword s4 = new Sword(24, 20, dungeon, true);
        dungeon.addEntity(s1);
        dungeon.addEntity(s2);
        dungeon.addEntity(s3);
        dungeon.addEntity(s4);
        p.moveRight();
        p.moveRight();

        Player p1 = new Player(dungeon, 5, 5);  
        dungeon.addEntity(p1);
        dungeon.setPlayer(p1);

        Wall w1 = new Wall(5, 4, dungeon, false);
        Wall w2 = new Wall(5, 6, dungeon, false);
        Wall w3 = new Wall(6, 5, dungeon, false);
        Wall w4 = new Wall(4, 5, dungeon, false);

            p.moveLeft();
            p.moveRight();
            p.moveUp();
            p.moveDown();
        // System.out.println(p.getCoordinate().getX() + " " + p.getCoordinate().getY());


    }
}