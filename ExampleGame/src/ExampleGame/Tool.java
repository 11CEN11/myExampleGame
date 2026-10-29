package ExampleGame;

public class Tool extends Item{
	
	private boolean usedTool;
	
	public Tool() {
		super("tool", false);
		usedTool = false;
	}
	
	@Override
	public void use() {
		if (runExampleGame.getCurrentRoom().getRoomName().equals("Bedroom")) {
			if (usedTool) {
				runExampleGame.print("You already opened the attic door!");
			} else {
				runExampleGame.getCurrentRoom().getExit(4).setLocked(false);
				usedTool = true;
				runExampleGame.print("Using the tool, you are able to…");
			} 
		}else {
			runExampleGame.print("You don't see any way to use the tool…");
		}
	}
}
