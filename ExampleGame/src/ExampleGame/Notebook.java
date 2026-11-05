package ExampleGame;

public class Notebook extends Item {
	
	public boolean usedBook;
	public boolean readBook;
	Item password = new Item("password", true);
	
	public Notebook() {
		super("notebook", false);
		readBook = false;
	}
	
	public String getName() {
		return "notebook";
	}
	
	@Override
	public void read() {
		for(int i=0; i<runExampleGame.pInventory.size(); i++) {
			if (runExampleGame.pInventory.get(i).getName().equals("notebook")) {
				if (readBook){
					runExampleGame.print("You already read the Notebook!");
				} else {
					readBook = true;
					runExampleGame.addInventoryItem(password);;
					runExampleGame.print("You obtained the password hidden in the Notebook!");
				}
			}
		}	
	}
}

