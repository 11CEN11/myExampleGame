package ExampleGame;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class NPC {
	
	private String name;
	
	public NPC(String n) {
		name = n;
	}
	
	public String getNPCName() {
		return name;
	}
	
	public void setNPCName(String n) {
		name = n;
	}
	
	public void say(String dialog) {
		runExampleGame.print(name.toUpperCase());
		runExampleGame.print(dialog);
	}
	
	public void talk() {
		runExampleGame.print("You can't talk to " + name);
	}
	
	public int getResponse(String[] responses) {
		for(int i = 0; i<responses.length; i++) {
			int m = i+1;
			runExampleGame.print(m+") "+responses[i]);
		}

		String input = JOptionPane.showInputDialog(null, "Choose an option:");
		int option = Integer.parseInt(input);
		return option;
	}
	
}
