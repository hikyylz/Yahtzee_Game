import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class HighScoreTable {
	
	static SingleLinkedList namesSLL = new SingleLinkedList();
	static SingleLinkedList ScoresSLL = new SingleLinkedList();
	static String highScoreTableLink = "yathzeeTable.txt";
	
	HighScoreTable(){
		readHighScoreFile();
	}
	
	static void refreashHighScoreTable(Object winnerName, Object winnerScore) {
		if(winnerName==null) {   // in case of tie , this if is needed.
			return;
		}
		
		try {
			FileWriter fw = new FileWriter(highScoreTableLink, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.newLine();
		    bw.write((String)winnerName);
		    bw.newLine();
		    bw.write( String.valueOf(winnerScore));
		    
		    bw.close();
		     
		    } catch (IOException e) {
		      System.out.println("An error occurred while writing to the table .");
		      e.printStackTrace();
		    }
	}
	
	
	void readHighScoreFile() {
		try {
			// we assume file contains data line by line.
			  File f = new File(highScoreTableLink);
		      Scanner myReader = new Scanner(f);
		      int way=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        
		        
		        if(way%2==0) {
		        	// çift ise isimleri tut bu linked list de.
		        	namesSLL.addBackward(data);
		        	way++;
		        }else {
		        	// tek sayı ise puanları başka bir linked list de tut.
		        	ScoresSLL.addBackward(data);
		        	way++;
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred while reading high score.txt .");
		      e.printStackTrace();
		    }
	}
}
