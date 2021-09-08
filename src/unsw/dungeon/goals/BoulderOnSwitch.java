package unsw.dungeon.goals;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Switch;


public class BoulderOnSwitch implements Goal {

    private Dungeon dungeon;
    private boolean isComplete;
    private String name;

    public BoulderOnSwitch(Dungeon dungeon) {
        this.dungeon = dungeon;
        this.isComplete = false;
        this.name = "Boulders";
    }

    @Override
    public boolean isComplete() {
        return this.isComplete;
    }

    @Override
    public void update() {
        for(Entity s : dungeon.searchEntity(Switch.class)){
            for(Entity b : dungeon.searchEntity(Boulder.class)){
                if(dungeon.checkOverlap(s, b) == true){
                    Switch a = (Switch) s;
                    a.setSwitchStatus("on");
                }
            }
            
        }

        boolean allswitched = true;
        for(Entity s : dungeon.searchEntity(Switch.class)){
            Switch a = (Switch) s;
            // Entity dungeon.getEntitiesAtXY(a.getX(), a.getY());
            if(a.getSwitchStatus() != "on"){
                allswitched = false;
            } else {
            System.out.println("a switch is on..");
            }
        }   

        if(allswitched == false){
            this.isComplete = false;
        }else{
            this.isComplete = true;
            System.out.println("all swticehs on");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}