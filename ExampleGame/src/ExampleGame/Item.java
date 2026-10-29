package ExampleGame;

import java.io.Serializable;

public class Item implements Serializable {
	private String itemName;
	private boolean isHeavy;
	
	public Item(String n, boolean y) {
		itemName = n;
		isHeavy = y;
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
	
}
