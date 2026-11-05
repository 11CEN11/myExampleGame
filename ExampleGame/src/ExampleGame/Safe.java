package ExampleGame;

public class Safe extends Item {
	
	public boolean opened;
	public boolean closed;
	public boolean first;
	
	public Safe() {
		super("safe", true);
		opened = false;
		closed = true;
		first = true;
	}
	
	@Override
	public void open() {
		if (closed && first) {
			closed = false;
			opened = true;
			first = false;
			Item notebook = new Notebook();
			runExampleGame.getCurrentRoom().setRoomItem(notebook.getName(), notebook);
			runExampleGame.print("You opened the safe and found a notebook!");
		}
		else if (closed && (first == false)) {
			closed = false;
			opened = true;
			runExampleGame.print("You opened the safe.");
		}			
	}
	
	@Override
	public void close() {
		if (opened) {
			opened = false;
			closed = true;
		}
	}
	
	
}
