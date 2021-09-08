package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Portal;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Wall;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Hound;
import unsw.dungeon.Entity.InvincibilityPotion;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.DexterityPotion;
import unsw.dungeon.Entity.Door;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.goals.BoulderOnSwitch;
import unsw.dungeon.goals.CollectTreasure;
import unsw.dungeon.goals.ComplexGoal;
import unsw.dungeon.goals.GetExit;
import unsw.dungeon.goals.Goal;
import unsw.dungeon.goals.KillEnemies;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Key;



/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }

        JSONObject jsonG = json.getJSONObject("goal-condition");
        Goal g = loadGoal(jsonG, dungeon);
        dungeon.setGoal(g);
        return dungeon;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y,dungeon,false);
            onLoad(wall);
            entity = wall;
            break;
        case "boulder":
            Boulder boulder = new Boulder(x, y, dungeon, false);
            onLoad(boulder);
            entity = boulder;
            break;
        case "door":
            Door door = new Door(x, y, dungeon, false, 1);
            onLoad(door);
            Door door_ = new Door(x, y, dungeon, true, 2);
            onLoadOpenDoor(door_);
            dungeon.addEntity(door_);
            entity = door;
            break;
        case "enemy":
            Enemy enemy = new Enemy(y, y, dungeon, true);
            onLoad(enemy);
            entity = enemy;
            break;
        case "exit":
            Exit exit = new Exit(x, y, dungeon, true);
            onLoad(exit);
            entity = exit;
            break;
        case "invincibility":
            InvincibilityPotion ip = new InvincibilityPotion(x, y, dungeon, true, 1000);
            onLoad(ip);
            entity = ip;
            break;
        case "key":
            Key key = new Key(x,y,dungeon,true,1);
            onLoad(key);
            entity = key;
            break;
        case "portal":
            Portal portal = new Portal(x, y, dungeon, true, 5);
            onLoad(portal);
            entity = portal;
            break;
        case "switch":
            Switch swi = new Switch(x, y, dungeon, true, 1);
            onLoad(swi);
            entity = swi;
            break;
        case "sword":
            Sword sword = new Sword(x, y, dungeon, true);
            onLoad(sword);
            entity = sword;
            break;
        case "treasure":
            Treasure treasure = new Treasure(x, y, dungeon, true, "treasure");
            onLoad(treasure);
            entity = treasure;
            break;
        case "dexterity":
            DexterityPotion dexterity = new DexterityPotion(x, y, dungeon, true, 1000);
            onLoad(dexterity);
            entity = dexterity;
            break;
        case "hound":
            Hound hound = new Hound(x,y, dungeon,true);
            onLoad(hound);
            entity = hound;
            break;
        }
        dungeon.addEntity(entity);
    }

    private Goal loadGoal(JSONObject jsonG,Dungeon dungeon){
        
        if (jsonG.getString("goal").equals("enemies")) {
            Goal g = new KillEnemies(dungeon);
            return g;
        }
        if (jsonG.getString("goal").equals("boulders")) {
            Goal g = new BoulderOnSwitch(dungeon);
            return g;
        }
        if (jsonG.getString("goal").equals("exit")) {
            Goal g = new GetExit(dungeon);
            return g;
        }
        if (jsonG.getString("goal").equals("treasure")) {
            Goal g = new CollectTreasure(dungeon);
            return g;
        }
		if (jsonG.getString("goal").equals("AND")) {
			ComplexGoal g = new ComplexGoal(dungeon, "AND");
            JSONArray subgoals = jsonG.getJSONArray("subgoals");
			for (int i = 0; i < subgoals.length(); i++) {
				JSONObject subgoal = subgoals.getJSONObject(i);
                g.addGoal(loadGoal(subgoal, dungeon));
            }
            return g;
        } 
        if (jsonG.getString("goal").equals("OR")) {
			ComplexGoal g = new ComplexGoal(dungeon, "OR");
            JSONArray subgoals = jsonG.getJSONArray("subgoals");
            
			for (int i = 0; i < subgoals.length(); i++) {
                
				JSONObject subgoal = subgoals.getJSONObject(i);
                g.addGoal(loadGoal(subgoal, dungeon));
                
            }
            return g;
        }
        return null;
        
    }

    public abstract void onLoad(Entity player);
    public abstract void onLoad(Wall wall);
    public abstract void onLoad(Boulder boulder);
    public abstract void onLoad(Door door);
    public abstract void onLoadOpenDoor(Door door);
    public abstract void onLoad(DexterityPotion dp);
    public abstract void onLoad(Enemy enemy);
    public abstract void onLoad(Exit exit);
    
    public abstract void onLoad(InvincibilityPotion ip);
    public abstract void onLoad(Key key);
    public abstract void onLoad(Portal portal);
    public abstract void onLoad(Switch switch1);
    public abstract void onLoad(Sword sword);
    public abstract void onLoad(Treasure treasure);
    public abstract void onLoad(Hound hound);

    // TODO Create additional abstract methods for the other entities

}
