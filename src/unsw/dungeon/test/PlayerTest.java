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
import unsw.dungeon.Entity.Wall;
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;

public class PlayerTest {
    
    @Test
    public void testBehaviour(){

        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 5, 5);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);

        p.moveRight();
        assertEquals(p.getX(), 6);
        p.moveLeft();
        assertEquals(p.getX(), 5);
        p.moveUp();
        assertEquals(p.getY(), 6);
        p.moveDown();
        assertEquals(p.getY(), 5);

        p.setPlayerStatus("dead");
        String a = p.getPlayerStatus();
        assertEquals(a, "dead");


        Sword b = new Sword(6, 5, dungeon, true);
        dungeon.addEntity(b);
        p.moveRight();
        b.interact(p);
        boolean boola = p.inventory.contains(b);
        assertEquals(boola, true);

        Treasure t1 = new Treasure(2, 2, dungeon, true, "t1");
        t1.interact(p);
        String a3 = t1.getName();

        Key k1 = new Key(2, 2, dungeon, true, 5);
        k1.interact(p);
        k1.interact(p);
        



}
}