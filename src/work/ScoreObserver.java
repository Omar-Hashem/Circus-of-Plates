package work;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreObserver implements Serializable {
	
	Integer  playerscore  ; 
	
	public Integer getPlayerscore() {
		return playerscore;
	}
	public void setPlayerscore(Integer playerscore) {
		this.playerscore = playerscore;
	}

	String display ; 
	String playername ; 
	
	public ScoreObserver( ) {
		
		playerscore= new Integer (0) ;
	}
	public void setplayernam (String pln ){
		this.playername = pln ; 
		display = playername+ "0" ; 

	}
	public void update (boolean increase ){
		if (increase ){
			playerscore++ ; 
		}
		else {
			playerscore-- ; 
		}
		display = playername + playerscore.toString (); 
	}
	public void update (Integer increase ){
		
		display = playername + increase.toString (); 
	}
	
	
	public String getScore (){
		return display ; 
	}
	
}
