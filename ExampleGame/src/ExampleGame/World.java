package ExampleGame; 

public class World {
	
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room");
		Room office = new Room("Office");
		Room kitchen = new Room("Kitchen");
		Room bedroom = new Room("Bedroom");
		Room attic = new Room("Attic");
		Room garage = new Room("Garage");
		Item officekey = new Item("officeKey", true);
		Item tool = new Item("tool", true);
		Item musicbox = new Item("musicBox", false);
		Item flashlight = new Item("flashlight", true);
		Item knife = new Item("knife", true);
		Item mysteriousorb = new Item("mysteriousOrb", true);
		
		
		bedroom.addExit(attic, 4); //4 = up
		bedroom.addExit(livingRoom, 3); //3 = south
		bedroom.setRoomItem("officekey", officekey);

		livingRoom.addExit(bedroom, 2); //2 = north
		livingRoom.addExit(office, 1); //1 = west
		livingRoom.addExit(kitchen, 0); //0 = east
		livingRoom.setRoomItem("tool", tool);
		livingRoom.setRoomItem("musicbox", musicbox);
		
		attic.addExit(bedroom, 5); //5 = down
		
		kitchen.addExit(livingRoom, 1); //1 = west
		kitchen.addExit(garage, 3); //3 = south
		kitchen.setRoomItem("flashlight", flashlight);
		kitchen.setRoomItem("knife", knife);
		kitchen.setRoomItem("mysteriousorb", mysteriousorb);
		
		office.addExit(livingRoom, 0); //0 = east
		
		garage.addExit(kitchen, 2); //2 = north
		
		
		
		return livingRoom;
	}
	
	
}

