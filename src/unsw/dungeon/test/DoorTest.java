package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.Door;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Key;
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;

public class DoorTest {
    


    @Test
    public void testBehaviour(){
    Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 5, 5);  
        dungeon.setPlayer(p);
        dungeon.addEntity(p);
        Enemy e = new Enemy(6, 5, dungeon, true);
        dungeon.addEntity(e);

        Door d1 = new Door(4, 4, dungeon, false, 5);
        Sword s1 = new Sword(1, 1, dungeon, true);
        Key k2 = new Key(1, 1, dungeon, true, 4);
        Key k1 = new Key(1, 1, dungeon, true, 5);
        p.addToInvesntory(k2);
        p.addToInvesntory(s1);

        p.addToInvesntory(k1);

        d1.interact(p);
        assertEquals(d1.getDoorStatus(), "open");
        d1.interact(p);
    }
    }