package ExampleGame;

public class Jotaro extends NPC {
	
	private int convoNumber;
	
	public Jotaro() {
		super("jotaro");
		convoNumber = 0;
	}
	
	@Override
	public void talk() {
		switch(convoNumber) { 
			case 0:
				firstTalk();
				break;
			case 1:
				convoOne();
				break;
			case 2:
				convoTwo();
				break;
			case 3:
				convoThree();
				break;
			default:
				say("Huh?...");
		}
	}
	
	public void firstTalk() {
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
					convoNumber = 1;
					break;
				case 2:
					say("I'm 17 and I know that sounds a bit crazy but believe me, I am. Don't try anything funny"
							+ " while I'm around");
					convoNumber = 2;
					break;
				case 3:
					say("Kick rocks. I don't care much for people who beg.");
					convoNumber = 3;
					break;
				default:
					say("Huh?...");
			}
	}
	
	public void convoOne() {
			say("I don't like talking about ghosts or weird things man. What do you want");
			String[] responses = 
				{
						"Are you afraid of something? I understand if it's hard to talk about.",
						"My bad man, I didn't mean to bring up any bad memories.",
						"Damn my bad. I'll leave you alone."
				};
			int option = getResponse(responses);
			switch(option) {
				case 1:
					say("Nah im not afraid but I am wary of letting newer people when it comes to this house.");
					break;
				case 2:
					say("It's all good. Be safe and tread lightly...");
					break;
				case 3:
					say("No problem.");
					break;
			}
	}
	
	public void convoTwo() {
		say("You're not up to anything are you? Whats going on?");
		String[] responses = 
			{
					"Nah I'm just interested in the strange phenomena that is inside this place",
					"Yeah I'm trying to unlock more rooms and figure out more about this place.",
					"Sorry for bothering, I'll be on my way..."
			};
		int option = getResponse(responses);
		switch(option) {
			case 1:
				say("Sometimes ignorance is bliss. I'm speaking from experience.");
				break;
			case 2:
				say("If you want a small hint, there's a tool in the living room that you might find.");
				break;
			case 3:
				say("Stay out of trouble...");
				break;
		}
	}		
	
	public void convoThree() {
		say("You coming back to beg for more money? If you are, you're not getting any.");
		String[] responses = 
			{
					"Yeah, can you please spare a dollar or two?",
					"Nah, I just want to know if you could guide me to opening one of these locked doors.",
					"While money would be great, I want to ask one question. What's your story?"
			};
		int option = getResponse(responses);
		switch(option) {
			case 1:
				say("You've got 5 seconds to get away from me before I swing on you.");
				break;
			case 2:
				say("I think it would be wise to search the living room for an item. It's a tool.");
				break;
			case 3:
				say("I've traveled the world on a great adventure and afterwards I've been researching the"
						+ " supernatural ever since.");
				break;
		}
	}		
					
}