package unsw.dungeon.DungeonMaker;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.goals.Goal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
// import org.json.simple.JSONValue.*;
// import org.json.simple.JSONObject;
// import org.json.simple.JSONObject.*;

// import org.json.simple.JSONArray.toJSONString;

public class DungeonMaker {
    private static FileWriter file;
    private String[][] grid;

    private List<Boolean> goals;
    public int mazeGoal;
    public int boulderGoal;
    public int enemiesGoal;
    public int treasureGoal;

    // 0 = nothing, 1 = wall, 2 = player, 3 = enemy
    // 4 = boulder, 5 = door, 6 = exit, 7 = invincPotion
    // 8 = key, 9 = dexPotion, 10 = portal, 11 = switch
    // 12 = sword, 13 = treasure,
    public DungeonMaker() {
        grid = new String[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[i][j] = "";
            }
        }
        mazeGoal = 0;
        boulderGoal = 0;
        enemiesGoal = 0;
        treasureGoal = 0;
    }

    public void setCell(int x, int y, String text) {
        grid[x][y] = text;
    }

    public String cellProperty(int x, int y) {
        return grid[x][y];
    }

    public void save() throws IOException {
        try {
            // System.out.println("in save func");
        int x = 10;
        int y = 10;
        String temp = "a";
        JSONObject dungeData = new JSONObject();
        dungeData.put("width", x);
        dungeData.put("height", y);
        JSONArray entityArray = new JSONArray();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                // System.out.println(i +" "+ j);

                temp = cellProperty(i, j);
                if (temp == "empty") continue;
                // System.out.println("temp:" + temp + "fin temp");

                //System.out.println(temp);
                JSONObject thisEntity = new JSONObject();
                thisEntity.put("x", i);
                thisEntity.put("y", j);
                thisEntity.put("type", temp);
                entityArray.put(thisEntity);
            }

        }
        dungeData.put("entities", entityArray);
        JSONObject goalconditions = new JSONObject();

        if (mazeGoal + boulderGoal + enemiesGoal + treasureGoal > 1){
            JSONObject andobj = new JSONObject();
            andobj.put("goal", "AND");
            JSONArray goalArray = new JSONArray();
            if (mazeGoal == 1) {
                JSONObject tempGoal = new JSONObject();
                tempGoal.put("goal", "maze");
                goalArray.put(tempGoal);
            }
            if (boulderGoal == 1) {
                JSONObject tempGoal = new JSONObject();
                tempGoal.put("goal", "boulders");
                goalArray.put(tempGoal);
            }
            if (enemiesGoal == 1) {
                JSONObject tempGoal = new JSONObject();
                tempGoal.put("goal", "enemies");
                goalArray.put(tempGoal);
            }
            if (treasureGoal == 1) {
                JSONObject tempGoal = new JSONObject();
                tempGoal.put("goal", "treasure");
                goalArray.put(tempGoal);
            }
                
            goalconditions.put("goal", "AND");
            goalconditions.put("subgoals", goalArray);
            dungeData.put("goal-condition", goalconditions);
        } else {
            if (mazeGoal == 1) {
                goalconditions.put("goal", "maze");
            }
            if (boulderGoal == 1) {
                goalconditions.put("goal", "boulders");
            }
            if (enemiesGoal == 1) {
                goalconditions.put("goal", "enemies");
            }
            if (treasureGoal == 1) {
                goalconditions.put("goal", "treasure");
            }
            dungeData.put("goal-condition", goalconditions);
        }
        //onsole.log(dungeData);

        // System.out.println("133");
        int numMaze = 0;
        String fileName = "CustomMaze" + numMaze;

        String data = dungeData.toString();
        
        File file = new File("dungeons/CustomMaze0.json");
        File file1 = new File("dungeons/atline40");

        // File tmpDir = new File("/var/tmp");
        // boolean exists = tmpDir.exists();

        // if (file.exists()){
        //     numMaze = numMaze + 1;
        //     fileName = "CustomMaze" + numMaze;
        //     file = new File(fileName);
        // }
        boolean written = false;
        while(written == false){
            if (file.exists()){
                numMaze = numMaze + 1;
                fileName = "CustomMaze" + numMaze;
                System.out.println(fileName + "exists...");
                file = new File("dungeons/" + fileName + ".json");   
                System.out.println("this DOES exist: " + fileName);

            } else {
                written = true;
                System.out.println("this DOES NOT exist: " + fileName);

            }
        }
        // while(file.exists()){
        //     numMaze = numMaze + 1;
        //     fileName = "CustomMaze" + numMaze;
        //     file = new File(fileName);
        // }
        
        

       
        System.out.println(dungeData.toString());
        
        String aaa = dungeData.toString(1);
        FileWriter out1;
        String namePath = "dungeons/" + fileName + ".json";
        out1 = new FileWriter(namePath);
        out1.write(aaa);
        out1.close();
        // file.write(obj.toJSONString());
        // try (FileWriter file = new FileWriter("employees.json")) {
 
        //     file.write(dungeData.to());
        //     file.flush();
 
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public List<Boolean> getGoals() {
        return goals;
    }

    public void addGoals(Boolean newGoal) {
        this.goals.add(newGoal);
    }

    public void setGoals(List<Boolean> goals) {
        this.goals = goals;
    }



}