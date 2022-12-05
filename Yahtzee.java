import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	Scanner scn = new Scanner(System.in);
	Player player1= new Player();
	Player player2= new Player();
	Random rnd = new Random();
	int dice1, dice2, dice3;
	int diceOutput;
	int score;
	SingleLinkedList matchedNbrs = new SingleLinkedList(); 
	HighScoreTable table = new HighScoreTable();
	
	Yahtzee(){
		
		System.out.print("Please enter A fantastic name: ");
		Object nameOfplayer1= scn.nextLine();
		player1.setName((String)nameOfplayer1);
		System.out.print("Please enter another A fantastic name: ");
		Object nameOfplayer2= scn.nextLine();
		player2.setName((String)nameOfplayer2);
		
		int round=1;
		while(round<11) {  			// MAİN LOOP
			System.out.println("\n - - Round : "+ round + "\n");
			
			clarifyDices();
			addItemsIntoPlayersll(player1,dice1,dice2,dice3);
			clarifyDices();
			addItemsIntoPlayersll(player2,dice1,dice2,dice3);
			printPlayerProperties();
			
			boolean flag=false;
			if( matchHappend(player1)) {
				preparePlayerScore(player1);
				flag=true;
			}
			if(matchHappend(player2)) {
				preparePlayerScore(player2);
				flag=true;
			}
			if(flag) {
				System.out.println();
				printPlayerProperties();
			}
			
			
			refreshmatchedNbrs();
			
			// just for a little slowmotion.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			round++;
		}
		
		// At the end of the game.
		printWinner(nameOfplayer1,nameOfplayer2);
		
		
		
		
	}
	
	// functions...
	
	void refreshmatchedNbrs() {
		matchedNbrs.head=null;
	}
	
	void printWinner(Object nameOfplayer1, Object nameOfplayer2) {
		Object winnerName=null;
		Object winnerScore=0;
		
		if(player1.getPlayerScore() < player2.getPlayerScore()) {
			System.out.println("\n - - - Winner is "+player2.getName() +"  :)");
			
			winnerName=nameOfplayer2 ;
			winnerScore=player2.getPlayerScore();
			HighScoreTable.namesSLL.addBackward(winnerName);
			HighScoreTable.ScoresSLL.addBackward(winnerScore);
			
		}else if(player1.getPlayerScore() > player2.getPlayerScore()) {
			System.out.println("\n Winner is "+player1.getName() +"  :)" );
			
			winnerName=nameOfplayer1;
			winnerScore=player1.getPlayerScore();
			HighScoreTable.namesSLL.addBackward(winnerName);
			HighScoreTable.ScoresSLL.addBackward(winnerScore);
			
		}else {
			System.out.println("\n Players draw , no winner :)");
		}
		
		HighScoreTable.refreashHighScoreTable(winnerName, winnerScore);
		HighScoreTable.ScoresSLL.sortList( HighScoreTable.namesSLL );
		// display table data now.
		System.out.print("\n\n - - High Score Table - -");
		HighScoreTable.namesSLL.displayNames();
		HighScoreTable.ScoresSLL.displayScores();
	}
	
	
	void printPlayerProperties() {

		System.out.print(player1.getName() + ":  ");
		player1.getPlayersll().display();
		System.out.println("    - - Score: "+ player1.getPlayerScore() );

		System.out.print(player2.getName() + ":  ");
		player2.getPlayersll().display();
		System.out.println("    - - Score: "+ player2.getPlayerScore() );
	}
	
	void preparePlayerScore(Player p){
		getYahtzeePoint(p);
		getLargeStraigthPoint(p);
	}
	
	void getYahtzeePoint(Player p) {
		//this loop make player gain all yathzee point.
		for(int nbr=1; nbr<7; nbr++) {
			int howManyNbr = p.getPlayersll().howMany(nbr);
			if(howManyNbr>=4) {
				
				// ı keep deleted nbr that make player gain point due to next step.
				matchedNbrs.addBackward(nbr);
				p.setPlayerScore( p.getPlayerScore()+10 );
				
				for(int  i=0; i<4 ; i++) {
					p.getPlayersll().deleteOneItem(nbr);
				}
				
						
			}
		}
		
	}
	
	
	void getLargeStraigthPoint(Player p ) {
		// now it's the time to check largeStraigth...
		boolean straigthDone=true;
		
		for(int nbr=1; nbr<7; nbr++) {
			
			if(p.getPlayersll().howMany(nbr)==0 && matchedNbrs.howMany(nbr)==0) {
				straigthDone=false;
				break;
			}
		}
		
		if(straigthDone) {
			p.setPlayerScore( p.getPlayerScore()+30 );
			
			for(int nbr=1; nbr<7; nbr++) {
				if(p.getPlayersll().howMany(nbr)>=1) {
					p.getPlayersll().deleteOneItem(nbr);
				}
			}
		}
		
	}
	

	boolean matchHappend(Player p) {
		
		if(yahtzeePointHappend(p)) {
			// en az 1 tane sayıdan 4 tane var bu playerın listesinde, true.
			return true;
		}else if(largeStraigthHappend(p)) {
			// sll de sıralı 1 2 3 4 5 6 var, true.
			return true;
		}else {
			// player iki türü de yapamıyor maalesef.
			return false;
		}
	}
	
	
	
	boolean yahtzeePointHappend(Player p) {
		
		for(int nbr=1; nbr<7; nbr++) {
			
			int howManyNbr = p.getPlayersll().howMany(nbr);
			if(howManyNbr>=4) {
				return true;
			}
		}
		return false;
	}
	
	boolean largeStraigthHappend(Player p) {
		
		for(int i=1; i<7 ;i++) {
			if( p.getPlayersll().howMany(i) ==0) {
				return false;
			}
		}
		return true;
		
	}
	
	void addItemsIntoPlayersll(Player p ,int dice1, int dice2, int dice3) {
		
		p.getPlayersll().addBackward(dice1);
		p.getPlayersll().addBackward(dice2);
		p.getPlayersll().addBackward(dice3);
		
	}
	
	void clarifyDices() {
		dice1=shakeTheDice();
		dice2=shakeTheDice();
		dice3=shakeTheDice();
	}
	
	int shakeTheDice(){
		diceOutput= rnd.nextInt(1, 7);
		return diceOutput;
	}
	
	
	
	
	
	
}
