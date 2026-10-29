package ExampleGame;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

public class runExampleGame {
	
	public static ArrayList<Room> Rooms = new ArrayList<>();
	private static Room currentRoom = World.buildWorld();
	public static ArrayList<Item> pInventory = new ArrayList<>();
	public static HashMap<String, String> roomDes = new HashMap<>();
	private static Consumer<String> guiOutput;
	
	public static void runGame() {
		Scanner input = new Scanner(System.in);
		String command = "lol";
		while (!command.equals("exit")) {
			print("Your current room is: "+currentRoom);
			print("Type the direction you want to go: ");
			print("OR");
			print("Type take to grab an item: ");
			print("OR");
			print("Type i to look at your inventory: ");
			print("OR");
			print("Type exit to finish:");
			command = input.nextLine();
			command.toLowerCase();
			String[] splcommand = command.split(" ");
			switch(splcommand[0]) {
			case "go":
				move(splcommand[1]);
				break;
			case "exit":
				print("Farewell! Thanks for playing!");
				break;
			case "take":
				takeItem(splcommand[1]);
				break;
			case "i":
				for(Item i : pInventory)
					print(i.toString());
			case "load":
				loadGame();
				System.out.println("Game Loaded Successfully!");
			case "save":
				saveGame();
				System.out.println("Game Saved Successfully!");
			default:
				print("ERROR");
				break;
			}
		} // end of while loop		
	}
	
	public static void print(Object obj) {
	    if (guiOutput != null) {
	        guiOutput.accept(String.valueOf(obj));
	    } else {
	        System.out.println(obj);
	    }
	}
	
	public static boolean processCommand(String command) {
	    command = command.trim().toLowerCase();
	
	    if (command.isEmpty()) {
	        return true;
	    }
	
	    print("> " + command);
	
	    String[] parts = command.split("\\s+", 2);
	
	    switch (parts[0]) {
	        case "go":
	            if (parts.length < 2) {
	                print("Go where?");
	            } else {
	                move(parts[1]);
	            }
	            break;
	
	        case "take":
	            if (parts.length < 2) {
	                print("Take what?");
	            } else {
	                takeItem(parts[1]);
	            }
	            break;
	
	        case "i":
	        case "inventory":
	            print("Your inventory:");
	            for (Item item : pInventory) {
	                print(item.toString());
	            }
	            break;
	
	        case "look":
	            print("Your current room is: " + currentRoom);
	            break;
	        
	        case "save":
	        	saveGame();
	        	print("Game was successfully saved!");
	        	break;
	        
	        case "load":
	        	loadGame();
	        	print("Game was successfully loaded!");
	        	break;
	        	
	        case "exit":
	            print("Farewell! Thanks for playing!");
	            return false;
	            
	        case "use":
	        	if (parts.length < 2) {
	        		print("Use what?");
	        		break;
	        	}
	        	for (Item i : pInventory) {
	        		if (i.getName().equals(parts[1])) {
	        			i.use();
	        			break;
	        		}
	        	}
	        default:
	            print("Unknown command. Try go north, take key, i, or exit.");
	            break;
	    }
	
	    print("");
	    print("Your current room is: " + currentRoom);
	    return true;
	}
	
	public static void move(String d) {
		int direction = 0;
		switch(d.toLowerCase()) {
		case "east":
			direction = 0;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		case "west":
			direction = 1;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		case "north":
			direction = 2;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}	
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		case "south":
			direction = 3;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		case "up":
			direction = 4;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		case "down":
			direction = 5;
			if (currentRoom.getExit(direction) == null) {
				print("You cannot go that way.");
			}
			else if (currentRoom.getExit(direction).getLocked() == true) {
				print("This room is locked. You have to find an item to get in!");
			}
			else {
				currentRoom = currentRoom.getExit(direction);
			}
			break;
		default:
			print("ERROR. NOT A VALID DIRECTION!");
			break;
		}
	}
	
	public static void takeItem(String n) {
		Item i = currentRoom.getRoomItem(n);
		if ((i != null && i.getName().equals(n)) && i.getheavy() == false) {
			pInventory.add(currentRoom.getRoomItem(n));
			print("You take the "+currentRoom.getRoomItem(n).getName()+" and carry it with you!");
			currentRoom.setRoomItem(n, null);
		}		
		else if ((i != null && i.getName().equals(n)) && i.getheavy() == true) {
			print("The "+n+" is too heavy to carry!");
		}
		else if (n.equals(null)){
			print("Take what?");
		}
		else if (i == null) {
			print("There is no "+n+" here.");
		}
	}
	
	public static void loadDesHash() {
		try {
			Scanner fileScan = new Scanner(new File("Room_Descriptions.txt"));
			while (fileScan.hasNextLine()) {
				String roomName = fileScan.nextLine();
				String roomDesc = "";
				String look = fileScan.nextLine();
				while (!look.equals("#")) {
					roomDesc += look;
					look = fileScan.nextLine();
				}
			roomDes.put(roomName, roomDesc);
			}
			fileScan.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

	public static void setGuiOutput(Consumer<String> output) {
	    guiOutput = output;
	}
	
	public static Room getCurrentRoom() {
	    return currentRoom;
	}
	
	public static void saveGame() {
		File saveFile = new File("save1.sav"); // name the file yourself
		try {
			saveFile.createNewFile();
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
			outStream.writeObject(currentRoom);
			outStream.writeObject(Rooms);
			outStream.writeObject(pInventory);
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // creates a new file	
	}
	
	public static void loadGame() {
		File saveFile = new File("save1.sav"); // name of save file
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
			currentRoom = (Room) inStream.readObject();
			Rooms = (ArrayList<Room>) inStream.readObject();
			pInventory = (ArrayList<Item>) inStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
	    loadDesHash();

	    SwingUtilities.invokeLater(() -> {
	        AdventureGUI game = new AdventureGUI();
	        game.setVisible(true);
	    });
	}
//	public static void main(String[] args) {
//		loadDesHash();
//		runGame();
//	}
} // end of runExampleGame class
