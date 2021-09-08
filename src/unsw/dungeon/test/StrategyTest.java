package test;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import unsw.dungeon.Coordinate;
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
import unsw.dungeon.Entity.Wall;
import unsw.dungeon.goals.BoulderOnSwitch;
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.ComplexGoal;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;
import unsw.dungeon.MovingStragety;

public class StrategyTest {
    
    @Test
    public void testStrategy(){
        Dungeon dungeon = new Dungeon(100,100);
        Player p = new Player(dungeon,1,1);
        dungeon.setPlayer(p);
        dungeon.addEntity(p);
        Enemy e = new Enemy(5, 5, dungeon, true);
        dungeon.addEntity(e);

        Wall w1 = new Wall(4, 5);
        Wall w2 = new Wall(6, 5);
        Wall w3 = new Wall(5, 4);
        dungeon.addEntity(w1);
        dungeon.addEntity(w2);
        dungeon.addEntity(w3);
        Wall w4 = new Wall(4,6);
        Wall w5 = new Wall(6,6);
        dungeon.addEntity(w4);
        dungeon.addEntity(w5);
        Wall w6 = new Wall(5,8);
        Wall w7 = new Wall(6,7);
        dungeon.addEntity(w6);
        dungeon.addEntity(w7);
        e.moveTowards();
        
        assertEquals(6,e.getY());
        e.moveTowards();
        assertEquals(7,e.getY());
        e.moveTowards();
        assertEquals(4,e.getX());
        e.moveTowards();
     
       

    }
}

    