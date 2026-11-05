package ExampleGame;

import java.io.Serializable;

public class Item implements Serializable {
	private String itemName;
	private boolean isHeavy;
	
	public Item(String n) {
		this(n, false);
	}
	
	public Item(String n, boolean heavy) {
		itemName = n;
		isHeavy = heavy;
	}
	
	public String getName() {
		return itemName;
	}
	
	public void setName(String n) {
		itemName = n;
	}
	
	public String toString() {
		return itemName;
	}
	
	public void setHeavy(boolean y) {
		isHeavy = y;
	}
	
	public boolean getheavy() {
		return isHeavy;
	}
	
	public void use() {
		runExampleGame.print("You cannot use this item here.");
	}
	
	public void open() {
		runExampleGame.print("You cannot open anything with this item here.");
	}
	
	public void close() {
		runExampleGame.print("You cannot close anything with this item here.");
	}
	
	public void read() {
		runExampleGame.print("You cannot read anything with this item here");
	}
	
}
