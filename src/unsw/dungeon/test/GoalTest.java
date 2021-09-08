package test;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import unsw.dungeon.Coordinate;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Key;
import unsw.dungeon.Entity.InvincibilityPotion;
import unsw.dungeon.goals.BoulderOnSwitch;
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.ComplexGoal;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;


public class GoalTest {
    

    @Test
    public void testSingleGoal(){
        ///////////////////test exit goal///////////////////
        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 1, 1);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);
        Exit e = new Exit(1,1,dungeon,true);
        dungeon.addEntity(e);
        Goal goal = new GetExit(dungeon);
        goal.update();
        goal.getName();
        assertEquals(goal.isComplete(), true);
        p.setXY(2, 2);
        goal.update();
        assertEquals(goal.isComplete(), false);


        //////////////////////test enemy goal/////////////////
        goal = new KillEnemies(dungeon);
        Enemy enemy1 = new Enemy(3, 3, dungeon, false);
        dungeon.addEntity(enemy1);
        goal.update();
        goal.getName();
        assertEquals(goal.isComplete(), false);
        dungeon.removeEntity(enemy1);
        goal.update();
        assertEquals(goal.isComplete(), true);

        /////////////////test treasure goal//////////////////
        goal = new CollectTreasure(dungeon);
        Treasure tr = new Treasure(4, 4, dungeon, false, "trea1");
        dungeon.addEntity(tr);
        goal.getName();
        goal.update();
        assertEquals(goal.isComplete(), false);
        dungeon.removeEntity(tr);
        goal.update();
        assertEquals(goal.isComplete(), true);


        ///////////test boulder goal/////////////
        goal  = new BoulderOnSwitch(dungeon);
        Boulder b = new Boulder(5, 5, dungeon, false);
        Switch s = new Switch(5, 5, dungeon, true, "untrigger", 1);
        dungeon.addEntity(s);
        dungeon.addEntity(b);
        goal.getName();
        goal.update();
        assertEquals(goal.isComplete(), true);
        s.setXY(6, 6);
        goal.update();
        assertEquals(goal.isComplete(), false);
    }

    @Test
    public void testComplexGoal(){
        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 1, 1);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);
        Exit e = new Exit(1,1,dungeon,true);
        dungeon.addEntity(e);
        Treasure tr = new Treasure(4, 4, dungeon, false, "trea1");
        dungeon.addEntity(tr);

        Goal g1 = new GetExit(dungeon);
        Goal g2 = new CollectTreasure(dungeon);
        ComplexGoal goals = new ComplexGoal(dungeon, "AND");
        ComplexGoal goals2 = new ComplexGoal(dungeon, "OR");
        goals.addGoal(g1);
        goals.addGoal(g2);
        goals2.addGoal(g1);
        goals2.addGoal(g2);
        goals.update();
        goals2.update();
        /////////////////// goals2 finish since g1 finsh "OR" /////////////////
        /////////////////// but goal not finish since "AND"   /////////////////
        assertEquals(goals2.isComplete(), true);
        assertEquals(goals.isComplete(), false);
        goals2.removeGoal(g1);
        assertEquals(goals2.isComplete(), false);
        dungeon.removeEntity(tr);
        goals.update();
        goals.getName();
        assertEquals(goals.isComplete(), true);

        Goal g3 = new KillEnemies(dungeon);
        goals.addGoal(g3);
        Enemy enemy1 = new Enemy(3, 3, dungeon, false);
        dungeon.addEntity(enemy1);
        goals.update();
        assertEquals(goals.isComplete(), false);
        dungeon.removeEntity(enemy1);
        goals.update();
        assertEquals(goals.isComplete(), true);
        e.getCoordinate().setX(8);
        e.getCoordinate().setY(8);
        e.getCoordinate().setXY(8,7);
        goals.update();
        assertEquals(goals.isComplete(), false);
    }
    @Test
    public void testt(){
        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 1, 1);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);
        Exit e = new Exit(1,1,dungeon,true);
        dungeon.addEntity(e);
        Treasure tr = new Treasure(4, 4, dungeon, false, "trea1");
        dungeon.addEntity(tr);
        List<Entity> aa = new ArrayList<Entity>();
        aa = dungeon.getEntitiesAtXY(4, 4);
        for(Entity bb : aa){
            // System.out.println(bb.getClass().toString());

        }
        
    }

    @Test
    public void testCoordinate(){
        Coordinate c1 = new Coordinate(1,1);
        assertEquals(c1.equals(null),false);
    }

    @Test
    public void testSearch(){
        Dungeon dungeon = new Dungeon(100, 100);
        Player p = new Player(dungeon, 11, 11);  
        dungeon.addEntity(p);
        dungeon.setPlayer(p);
        Exit e = new Exit(1,1,dungeon,true);
        dungeon.addEntity(e);
        Coordinate c1 = new Coordinate(1,1);
        //assertNotNull(dungeon.getEntities(c1, e.getClass());

    }
    
}