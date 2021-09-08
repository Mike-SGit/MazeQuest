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

public class MoveableTest {


    @Test
    public void testBehaviour(){
        Dungeon dungeon = new Dungeon(3, 3);
            Enemy p = new Enemy(2, 2, dungeon, true);
            dungeon.addEntity(p);
            p.moveDown();
            p.moveDown();
            p.moveDown();
            p.moveDown();
            p.moveDown();
            p.moveDown();

            p.moveLeft();
            p.moveLeft();

            p.moveLeft();

            p.moveLeft();

            p.moveLeft();

            p.moveLeft();


            p.moveRight();
            p.moveRight();

            p.moveRight();

            p.moveRight();

            p.moveRight();

            p.moveRight();

            p.moveUp();
            p.moveUp();

            p.moveUp();

            p.moveUp();

            p.moveUp();

            p.moveUp();

            p.moveUp();

            p.moveUp();



            // System.out.println("aaa" + p.getX() + p.getY());

    }
}