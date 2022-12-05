
public class Player {

	private int playerScore;
	private String name;
	private SingleLinkedList Playersll;
	
	
	Player(){
		Playersll= new SingleLinkedList();
		playerScore=0;
	}


	public int getPlayerScore() {
		return playerScore;
	}


	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}


	public SingleLinkedList getPlayersll() {
		return Playersll;
	}


	public void setPlayersll(SingleLinkedList playersll) {
		Playersll = playersll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
