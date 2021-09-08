package unsw.dungeon.Entity;

import java.util.List;

import unsw.dungeon.Coordinate;
import unsw.dungeon.Dungeon;
import unsw.dungeon.MovingStragety;

import java.util.ArrayList;

// import javax.swing.text.html.parser.Entity;
// unfinished, needs automatic behaviours
public class Enemy extends Moveable implements Observer {

    public String status;
    public String behaviourStatus; //Toward || Away
    private String lastMove;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(int x, int y, Dungeon dungeon, boolean passable) {
        super(x, y, dungeon, passable);
        this.status = "alive";
        this.behaviourStatus = "aggressive";
        this.lastMove = "null";
    }

    public void update(Player player){
        if (player.playerState.name == "invincible"){
            setBehaviour("afraid");
        } else if (player.playerState.name != "invincible"){
            setBehaviour("aggressive");
        } else {
            return;
        }
        return;
    }
    public void setBehaviour(String behaviourStatus){
        this.behaviourStatus = behaviourStatus;
    }

    public void die(){
        this.getDungeon().hideItem(this);
        this.getDungeon().removeEntity(this);
        this.getDungeon().trackGoal();
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getLasttMove(){
        return this.lastMove;
    }
    public String getBehabiour(){
        return this.behaviourStatus;
    }

    // void moveTick(){
    //     this.recentcoord.setXY(this.getCoordinate().getX(), this.getCoordinate().getY());
    //     Coordinate playercoord = getDungeon().getPlayerPosition();
    //     int direction = 0; //1 for up 2 for right 3 for down 4 for left
    //     if (this.getDungeon().getPlayer().getPlayerStatus() == "invincible"){
    //         moveAway();
    //     } else {
    //         moveTowards();//get path to player
    //     } 
            
    //     //get player/enemy cords
    //     //
    // }
    public void justMove(){
        if (this.getBehabiour() == "Toward"){
            moveTowards();
        }else{
            moveAway();
        }
    }

    public void moveTowards() {
        Dungeon d = this.getDungeon();
        Coordinate playercoord = this.getDungeon().getPlayerPosition();
        Coordinate enemycoord = this.getCoordinate();
        int distUp = playercoord.getY() - enemycoord.getY();
        int distDown = enemycoord.getY() - playercoord.getY();
        int distRight = playercoord.getX() - enemycoord.getX();
        int distLeft = enemycoord.getX() - playercoord.getX();
        String s = "";
        if (distUp > 0){
            s= s +"Down";
        }
        if(distDown > 0){
            s = s + "Up";
        }
        if(distLeft > 0 ){
            s = s + "Left";
        }
        if(distRight > 0 ){
            s = s+ "Right";
        }

        MovingStragety.move(s, this, d);



    }

    public void moveAway() {
        Dungeon d = this.getDungeon();
        Coordinate playercoord = this.getDungeon().getPlayerPosition();
        Coordinate enemycoord = this.getCoordinate();
        int distUp = playercoord.getY() - enemycoord.getY();
        int distDown = enemycoord.getY() - playercoord.getY();
        int distRight = playercoord.getX() - enemycoord.getX();
        int distLeft = enemycoord.getX() - playercoord.getX();
        String s = "";
        if (distUp > 0){
            s= s +"Up";
        }
        if(distDown > 0){
            s = s + "Down";
        }
        if(distLeft > 0 ){
            s = s + "Right";
        }
        if(distRight > 0 ){
            s = s+ "Left";
        }

        MovingStragety.move(s, this, d);
        
    
    }

    @Override
    public void interact(Player player){  
        if (this.getX() == player.getX() && this.getY() == player.getY()){
        player.getPlayerState().enemyPlayerInteraction(this);
        }
        System.out.println("interact(p) on enemyjava");
        
        justMove();
    }

    @Override
    public void moveDown() {
        boolean blocked = MovingStragety.checkBlocked(this.getCoordinate(),this.getDungeon(),"Down");
        if (blocked == false){
            System.out.println("enemy moving from y:" +this.getY() + " to...");
            this.setY(getY()+1);
            System.out.println(this.getY());

            this.lastMove = "Up";
            return;
        } else {
            System.out.println("enemy is blocked");

        }

    }
    
    @Override
    public void moveLeft() {
        boolean blocked = MovingStragety.checkBlocked(this.getCoordinate(),this.getDungeon(),"Left");
        
        if (blocked == false){
            this.setX(getX()-1);
            this.lastMove = "Right";
        }
    }
    
    @Override
    public void moveRight() {
        
        boolean blocked = MovingStragety.checkBlocked(this.getCoordinate(),this.getDungeon(),"Right");
        if (blocked == false){
            this.setX(getX()+1);
            this.lastMove = "Left";
        }
    }
    
    @Override
    public void moveUp() {
        boolean blocked = MovingStragety.checkBlocked(this.getCoordinate(),this.getDungeon(),"Up");
        if (blocked == false){
            this.setY(getY()-1);
            this.lastMove = "Down";
        }
    }
    }

  

    

    




