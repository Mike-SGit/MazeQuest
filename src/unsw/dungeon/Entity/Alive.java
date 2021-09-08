package unsw.dungeon.Entity;

import java.util.ArrayList;
import java.util.List;

import unsw.dungeon.Dungeon;
import unsw.dungeon.MovingStragety;

public class Alive extends State {

    Alive(Player player) {
        super(player);
        this.name = "Alive";
        //player.setPlaying(false);
        player.getDungeon().setAllEnemy("Toward");
    }

    @Override
    public void enemyPlayerInteraction(Enemy a) {
        System.out.println("player died to enemy");

        ArrayList <Item> e0 = player.getPlayerInventory();
        for (Item thisItem : e0) {
			if (thisItem instanceof Sword ) {
                Sword s = (Sword)thisItem;
                s.loseDurability();
                if (s.getDurability() == 0) {
                    e0.remove(s);
                }
                a.die();
                a.getDungeon().removeEntity(a);
                return;
            }
        
        }
        player.changeState(new Dead(player));
    }

    @Override
    public State getState(){
        return this;
    }

    @Override
    public String getStateName(){
        return this.name;
    }

    public void onInvPotion(){
        player.changeState(new Invincible(player));
    }

    public  void onDexPotion(){
        player.changeState(new Dexterity(player));
    }

    



    @Override
    public void moveUp() {
        boolean blocked = player.isPathBlocked(this.player.getX(), this.player.getY()+1);
        boolean pushBoulder = player.pushableBoulder(this.player.getX(), this.player.getY()+1, this.player.getX(), this.player.getY()+2);
        player.openabledoor(this.player.getX(), this.player.getY()+1);

        if (pushBoulder == true){
            List <Entity> e0 = this.player.getDungeon().getEntitiesAtXY(this.player.getX(), this.player.getY()+1);
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    a.setY(a.getY()+1);
                    a.activateSwitches();
                    
                }
                // this.player.getCoordinate().setXY(this.player.getCoordinate().getX(), this.player.getCoordinate().getY()+1);
                this.player.setY(this.player.getY()+1);

                return;
		    }
        }
        
		if (blocked == false){
            // this.player.getCoordinate().setXY(this.player.getCoordinate().getX(), this.player.getCoordinate().getY()+1);
            this.player.setY(this.player.getY()+1);
            player.playerInteract();
        }
    }
    @Override
    public void moveLeft() {
        System.out.println("in alive move left");
        boolean blocked = player.isPathBlocked(this.player.getX()-1, this.player.getY());
        boolean pushBoulder = player.pushableBoulder(this.player.getX()-1, this.player.getY(), this.player.getX()-2, this.player.getY());
        player.openabledoor(this.player.getX()-1, this.player.getY());
        
        if (pushBoulder == true){
            List <Entity> e0 = this.player.getDungeon().getEntitiesAtXY(this.player.getX()-1, this.player.getY());
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    a.setX(a.getX()-1);

                    // entity.getCoordinate().setXY(entity.getCoordinate().getX()-1, entity.getCoordinate().getY());
                    a.activateSwitches();
                }
                // this.player.getCoordinate().setXY(this.player.getCoordinate().getX()-1, this.player.getCoordinate().getY());
                this.player.setX(this.player.getX()-1);

                return;
		    }
        }


		if (blocked == false){
            // this.player.getCoordinate().setXY(this.player.getCoordinate().getX()-1, this.player.getCoordinate().getY());
            this.player.setX(this.player.getX()-1);


            player.playerInteract();
        } else {
        System.out.println("alive move left blocked");

        }
    }

    @Override
    public void moveRight() {
        System.out.println("in alive move right");

        System.out.println("moving from ");

        boolean blocked = player.isPathBlocked(this.player.getX()+1, this.player.getY());
        boolean pushBoulder = player.pushableBoulder(this.player.getX()+1, this.player.getY(), this.player.getX()+2, this.player.getY());
        player.openabledoor(this.player.getX()+1, this.player.getY());

        System.out.println("pushBolder returned..  " + pushBoulder);

        if (pushBoulder == true){
            System.out.println("into if ");
            List <Entity> e0 = this.player.getDungeon().getEntitiesAtXY(this.player.getX()+1, this.player.getY());
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    a.setX(a.getX()+1);
                    a.activateSwitches();
                    
                }
            
                // this.player.getCoordinate().setXY(this.player.getCoordinate().getX()+1, this.player.getCoordinate().getY());
            this.player.setX(this.player.getX()+1);

                return;
		    }
        }
        System.out.println(blocked);
		if (blocked == false){
        

            // this.player.getCoordinate().setXY(this.player.getCoordinate().getX()+1, this.player.getCoordinate().getY());
            this.player.setX(this.player.getX()+1);
            
            System.out.println("call interact");
            player.playerInteract();
        }
    }
    @Override
    public void moveDown() {
        boolean blocked = MovingStragety.checkBlocked(this.player.getCoordinate(), this.player.getDungeon(), "Up");
        boolean pushBoulder = player.pushableBoulder(this.player.getX(), this.player.getY()-1, this.player.getX(), this.player.getY()-2);
        player.openabledoor(this.player.getX(), this.player.getY()-1);

        if (pushBoulder == true){
            List <Entity> e0 = this.player.getDungeon().getEntitiesAtXY(this.player.getX(), this.player.getY()-1);
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    a.setY(a.getY()-1);
                    a.activateSwitches();
                }
                // this.player.getCoordinate().setXY(this.player.getCoordinate().getX(), this.player.getCoordinate().getY()-1);
                this.player.setY(this.player.getY()-1);

                return;
		    }
        }

		if (blocked == false){
            this.player.setY(this.player.getY()-1);

            // this.player.getCoordinate().setXY(this.player.getCoordinate().getX(), this.player.getCoordinate().getY()-1);
            player.playerInteract();

        }
    }
    
}