package ExampleGame;

public class OfficeKey extends Item {
	
	private boolean usedTool;
	
	public OfficeKey() {
		super("officekey", false);
		usedTool = false;
	}
	@Override
	public void use() {
		if (runExampleGame.getCurrentRoom().getRoomName().equals("Living Room")) {
				if (usedTool) {
						runExampleGame.print("You already opened the the Office door!");
				} else {
					runExampleGame.getCurrentRoom().getExit(1).setLocked(false);
					usedTool = true;
					runExampleGame.print("Using the Office Key, you are able to enter the Office.");
				}
		} else {
			runExampleGame.print("You don't see any way to use the Office Key.");
		}
	}
}
