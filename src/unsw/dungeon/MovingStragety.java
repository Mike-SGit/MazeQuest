package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

//import test.MoveableTest;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Entity;

public class MovingStragety {


    public void MovingStrategy() {

    }

    public static void move(String s, Enemy e, Dungeon d){
        Coordinate c = e.getCoordinate();
        List<Entity> l = d.getAdjacentEntities(c);
        List<String> movable_list = movableDirection(c, d);
        int num = 0;
        for (Entity e0 : l) {
            if (e0.getPassable() == false) {
                num++;
            }
        }
        if (num == 4) {
            return;
        }
        if (num == 3) {
            if (checkContain(movable_list, "Up")) {
                e.moveUp();
                return;
            }
            if (checkContain(movable_list, "Down")) {
                e.moveDown();
                return;
            }
            if (checkContain(movable_list, "Left")) {
                e.moveLeft();
                return;
            }
            if (checkContain(movable_list, "Right")) {
                e.moveRight();
                return;
            }
            randomMove(e, d);
        }
        if (num == 2) {
            if(movable_list.size() > 1 && checkContain(movable_list, e.getLasttMove())){
                movable_list.remove(e.getLasttMove());
            }
            if (s.contains("Up") && movable_list.contains("Up")) {
                e.moveUp();
                return;
            }
            if (s.contains("Down") && movable_list.contains("Down")) {
                e.moveDown();
                return;
            }
            if (s.contains("Left") && movable_list.contains("Left")) {
                e.moveLeft();
                return;
            }
            if (s.contains("Right") && movable_list.contains("Right")) {
                e.moveRight();
                return;
            }
            randomMove(e, d);
        }
        if (num == 1) {
            if (s.contains("Up") && movable_list.contains("Up")) {
                e.moveUp();
                return;
            }
            if (s.contains("Down") && movable_list.contains("Down")) {
                e.moveDown();
                return;
            }
            if (s.contains("Left") && movable_list.contains("Left")) {
                e.moveLeft();
                return;
            }
            if (s.contains("Right") && movable_list.contains("Right")) {
                e.moveRight();
                return;
            }
            randomMove(e, d);
        }
        if (num == 0) {
            if (s.contains("Up") && movable_list.contains("Up")) {
                e.moveUp();
                return;
            }
            if (s.contains("Down") && movable_list.contains("Down")) {
                e.moveDown();
                return;
            }
            if (s.contains("Left") && movable_list.contains("Left")) {
                e.moveLeft();
                return;
            }
            if (s.contains("Right") && movable_list.contains("Right")) {
                e.moveRight();
                return;
            }
        }
    }

    public static void randomMove(Enemy e, Dungeon d) {
        List<String> l = movableDirection(e.getCoordinate(), d);
        if (checkContain(l, "Up")) {
            e.moveUp();
            return;
        }
        if (checkContain(l, "Down")) {
            e.moveDown();
            return;
        }
        if (checkContain(l, "Left")) {
            e.moveLeft();
            return;
        }
        if (checkContain(l, "Right")) {
            e.moveRight();
            return;
        }
    }

    public static boolean checkContain(List<String> list, String st) {
        for (String s: list){
            if(s.equals(st)){
                return true;
            }
        }
        return false;
    }

    public static List<String> movableDirection(Coordinate c, Dungeon d) {
        List<String> l = new ArrayList<String>();
        l.add("Up");
        l.add("Down");
        l.add("Left");
        l.add("Right");
        if(checkBlocked(c, d, "Up")) {
            l.remove("Up");
        }
        if (checkBlocked(c, d, "Down")) {
            l.remove("Down");
        }
        if (checkBlocked(c, d, "Left")) {
            l.remove("Left");
        }
        if (checkBlocked(c, d, "Right")) {
            l.remove("Right");
        }

        return l;
    }

    public static boolean checkBlocked(Coordinate c, Dungeon d, String s) {
        int x = c.getX();
        int y = c.getY();
        
        if(s == "Left"){
            if(isBlocked(x - 1, y, d)) {
                return true;
            }
        }
        if (s == "Right") {
            if (isBlocked(x + 1, y, d)) {
                return true;
            }
        }
        if (s == "Down") {
            if (isBlocked(x, y + 1, d)) {
                return true;
            }
        }
        if (s == "Up") {
            if (isBlocked(x, y - 1, d)) {
                return true;
            }
        }
        return false;

    }

    public static boolean isBlocked(int x, int y, Dungeon d) {
        List <Entity> e = d.getEntitiesAtXY(x, y);
            for (Entity entity : e) {
                if (entity.getPassable() == false) {
                    return true;
                }
            }
            return false;
    }
    
}