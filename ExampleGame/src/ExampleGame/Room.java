package ExampleGame;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	
	private Room[] rooms;
	private String roomName;
	private HashMap<String, Item> roomItems;
	private boolean locked;
	
	public Room(String n, boolean l) {
		roomName = n;
		rooms = new Room[6];
		roomItems = new HashMap<>();
		runExampleGame.Rooms.add(this);
		locked = l;
	}
	
	public boolean getLocked() {
		return locked;
	}
	
	public void setLocked(boolean l) {
		locked = l;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public String getDescription() {
		return runExampleGame.roomDes.get(roomName);
	}
	
	public void setRoomName(String n) {
		roomName = n;
	}
	
	public void setDescription(String d) {
		runExampleGame.roomDes.replace(roomName, d);
	}
	
	public void addExit(Room r, int i) {
		rooms[i] = r;
	}
	
	public Room getExit(int i) {
		return rooms[i];
	}
	
	public Item getRoomItem(String n) {
		return roomItems.get(n);
	}
	
	public void setRoomItem(String n, Item i) {
		roomItems.put(n, i);
	}
	
	public void removeItem(String n) {
		roomItems.remove(n);
	}
	
	public String toString() {
		String r = "Room Name: " + roomName;
		r += "\n" + "Description: " + runExampleGame.roomDes.get(roomName);
		return r;
	}
	
	
	
}
