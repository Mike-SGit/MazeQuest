package unsw.dungeon.Entity;

import unsw.dungeon.Dungeon;

abstract class Item extends Entity {


	public Item(int x, int y, Dungeon dungeon, boolean passable) {
		super(x, y, dungeon, passable);
	}

    //abstract method for itemInteract method overrides
	public abstract void interact(Player player);




}