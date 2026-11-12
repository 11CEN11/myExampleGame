package ExampleGame;

public class Jotaro extends NPC {
	
	public Jotaro() {
		super("jotaro");
	}
	
	@Override
	public void talk() {
		say("What up. What do you want.");
		String[] responses = 
			{
					"Anything weird around here ever happen?",
					"How old are you? You look like you're a 25 year old strongman.",
					"You got any spare money lying around? Im kinda struggling right now."
			};
		int option = getResponse(responses);
		switch(option) {
			case 1:
				say("Depends what you define as weird. I swear I saw a ghost last week but I could"
						+ " be just a bit paranoid");
				break;
			case 2:
				say("I'm 17 and I know that sounds a bit crazy but believe me, I am. Don't try anything funny"
						+ " while I'm around");
				break;
			case 3:
				say("Kick rocks. I don't care much for people who beg.");
				break;
			default:
				say("Huh?...");
		}
	}
}