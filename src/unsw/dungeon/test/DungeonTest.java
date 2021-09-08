package test;

import org.junit.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Player;

public class DungeonTest {

    

    @Test
    public void test1(){
        ///////////////////test exit goal///////////////////
        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 1, 1);  
    }
}