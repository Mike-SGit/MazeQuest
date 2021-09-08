package unsw.dungeon.Entity;

public abstract class State {
    Player player;
    String name;
    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }



    public abstract void onInvPotion();
    public abstract void onDexPotion();
    // public abstract void onInvPotionTimeout();
    // public abstract void onDexPotionTimeout();

    public abstract State getState();
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void enemyPlayerInteraction(Enemy a);
    public abstract String getStateName();

}
