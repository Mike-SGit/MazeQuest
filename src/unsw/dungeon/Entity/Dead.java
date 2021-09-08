package unsw.dungeon.Entity;

public class Dead extends State  {

    Dead(Player player) {
        super(player);
        this.name = "dead";
        //player.setPlaying(false);
        this.player.getDungeon().setStatus("dead");
        System.out.println("dun status is dead");
    }
    @Override
    public void moveUp(){
        return;
    }
    @Override
    public void moveDown(){
        return;
    }
    @Override
    public void moveLeft(){
        return;
    }
    @Override
    public void moveRight(){
        return;
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
        return;
    }

    public  void onDexPotion(){
        return;
    }

    @Override
    public void enemyPlayerInteraction(Enemy a) {
        return;
    }
    
}