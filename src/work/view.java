package work;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import shapes.rectangle;
import shapes.shape;

public class view extends JPanel implements KeyListener {
	
	
	

	static player pl1;
	static player pl2;
	Random randm ;
	boolean flag=false;
	int randnumber ; 
	BufferedImage back;
	pool p=pool.getPool();
	int score1=0;
	int score2=0;
	static score scor1;
	static score scor2;
	JLabel  score1label, score2label ,winner ; 
	static ScoreObserver s1 ;
	static ScoreObserver s2; 
	createmomento m;
	String ttt=""; 
	int counter=0;
	ArrayList<momento> mm;
	BigInteger timecounter = BigInteger.valueOf(0) ; 

	ArrayList<shape> shapes = new ArrayList<shape>();
	public Timer time;
	public Timer time2 ; 
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public view() throws IOException {
//		this.setLayout(new BorderLayout());
		this.setLayout(null);
		p.fill();
		this.setPreferredSize(new Dimension (1680,900));
		super.repaint();	
		scor1=new score();
		scor2=new score();
		s1=new ScoreObserver() ; 
		s1.setplayernam("player1  " );
		s2=new ScoreObserver() ; 
		s2.setplayernam("player2  " );

		score1label= new JLabel () ;
		score2label=  new JLabel (); 
		
		score1label.setHorizontalTextPosition(JLabel.CENTER);
		score1label.setVerticalTextPosition(JLabel.BOTTOM);
		score1label.setFont(new Font("Serif", Font.PLAIN, 60));
		score1label.setBounds(600,10, 1000,100);
		winner = new JLabel () ;
		winner.setHorizontalTextPosition(JLabel.CENTER);
		winner.setVerticalTextPosition(JLabel.BOTTOM);
		winner.setFont(new Font("Serif", Font.PLAIN, 60));
		winner.setBounds(780,300, 1000,100);
		
		score2label.setHorizontalTextPosition(JLabel.CENTER);
		score2label.setVerticalTextPosition(JLabel.BOTTOM);
		score2label.setFont(new Font("Serif", Font.PLAIN, 60));
		score2label.setBounds(900,10, 1000,100);

		
		this.add(score1label) ; 
		this.add (score2label); 
		this.add(winner ); 
		
		randm = new Random ();
		back = ImageIO.read(new File("back.png"));
		pl1 = new player(900);
		pl1.setcolor(Color.gray);
		pl1.flagg=true ;
		pl2 = new player(600);
		pl2.setcolor(Color.white);
		pl2.flagg=false ;
        m=new createmomento();
		time = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag)
				{momento ls;
				ls=new momento(pl1.getPlayershapesl(),pl2.getPlayershapesl(),shapes,pl1.getPlayershapesr(),pl2.getPlayershapesr(),pl1.getcheckx(),pl2.getcheckx(),s1.getPlayerscore(),s2.getPlayerscore());
				m.ad(ls);
				change();
				repaint();
				check (); 
				}
				else
				{
					
				mm	=m.getM();
				if(counter<mm.size())
				{
				pl1.setPlayershapesl(mm.get(counter).getA());
				pl1.setPlayershapesr(mm.get(counter).getA1());
				pl2.setPlayershapesl(mm.get(counter).getB());
				pl2.setPlayershapesr(mm.get(counter).getB1());
				shapes=(mm.get(counter).getS());
				pl1.setx(mm.get(counter).getX1());
				pl2.setx(mm.get(counter).getX2());
				s1.setPlayerscore(mm.get(counter).getY1());
				s2.setPlayerscore(mm.get(counter).getY2());
				s1.update(mm.get(counter).getY1());
				s2.update(mm.get(counter).getY2());
				repaint();
				counter++;
				}
				}
			}
		});
		time.start();
		time2 = new Timer(750, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				s1.update(true);
				
				
				if(!flag)
				 {
					randnumber= randm.nextInt(1480) ; 
					fillarray();
						
					
					
					
					timecounter = timecounter.add(BigInteger .valueOf(1)); 
					if (timecounter.equals(BigInteger.valueOf(130))){
						if (s1.playerscore>s2.playerscore){
							ttt = "player 1 wins" ; 
						}
						else if (s1.playerscore<s2.playerscore){
							ttt = "player2 wins" ; 
						}
						else {
							ttt= "equal score" ; 
						}
						repaint(); 
						time.stop();
						time2.stop();
					}
					
					
					
					
					
					
				 }
			}
		});
		time2.start();
		addKeyListener(this);
	}
	public void addjl(){
		this.add(winner ); 
	}
	public void fillarray() {
		shape temp =p.getShape();
		temp.setX(randnumber);
		temp.setY(0);
		shapes.add(temp);
		//shapes.add(new rectangle(randnumber, 0));
	}

	public void draw(Graphics2D g2d) {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).Draw(g2d);
		}
	}

	public void change() {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).move();
		}
	}

	
	
	public void check (){
		for (int i=0;i<shapes.size() ;i++ ){
			//over player1 
			if (shapes.get(i).overplayerl(pl1)) {
				shape temp = shapes.get(i); 
				shapes.remove(i);
				pl1.takeshapel(temp);
 
			}
			else if (shapes.get(i).overplayerr(pl1)) {
				shape temp = shapes.get(i); 
				shapes.remove(i);
				pl1.takeshaper(temp);
 
			}
			//over player2 
			else if (shapes.get(i).overplayerl(pl2)){
				shape temp = shapes.get(i); 
				shapes.remove(i);
				pl2.takeshapel(temp);
 
			}
			else if (shapes.get(i).overplayerr(pl2)){
				shape temp = shapes.get(i); 
				shapes.remove(i);
				pl2.takeshaper(temp);
			}
			//out of bounds 
			else if(shapes.get(i).checkboundary())
			{
				p.back(shapes.get(i));
				shapes.remove(i);
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(back, 0, 0, null);
		
		score2label.setText(String.valueOf(s2.getScore()));
		score2label.setForeground(Color.gray);
		score1label.setText(String.valueOf(s1.getScore()));
		score1label.setForeground(Color.white);
		winner.setText(ttt);
		winner.setForeground(Color.white);

		draw(g2d);
		pl1.draw(g2d);
		pl2.draw(g2d);
		
		
		
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	

	private final Set<Integer> pressed = new HashSet<Integer>();
		@Override
			public synchronized void keyPressed(KeyEvent e) {
				pressed.add(e.getKeyCode());
			for (int x : pressed) {
					int keycode = e.getKeyCode();
					
					if ( x==37) {
						if (pl1.x > 10) {
							pl1.setx(pl1.getx()-10);
						}
						
						repaint();
					}
					if (x==39) {
						if (pl1.x < 1500) {
							pl1.setx(pl1.getx()+10);
						}
						repaint();
					}
					if (x== 'a'|| x=='A') {
						if (pl2.x > 10) {
							pl2.setx(pl2.getx()-10);
						}
						repaint();
					}
					if (x== 'd' || x=='D') {
						if (pl2.x < 1500) {
							pl2.setx(pl2.getx()+10);
						}
				}

			}

	}

	public void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
	}
	public space save()
	{
	 return new space(pl1.getPlayershapesl(),pl2.getPlayershapesl(),pl1.getPlayershapesr(),pl2.getPlayershapesr(),pl1.getcheckx(),pl2.getcheckx(), s1, s2);
	}
	public static void load(space m)
	{
		pl1.setPlayershapesl(m.getA());
		pl1.setPlayershapesr(m.getA1());
		pl1.setyl(m.getA().size());
		pl1.setyr(m.getA1().size());
		pl2.setPlayershapesl(m.getB());
		pl2.setPlayershapesr(m.getB1());
		pl2.setyl(m.getB().size());
		pl2.setyr(m.getB1().size());
		pl1.setx(m.getX1());
		pl2.setx(m.getX2());
		s1=m.getS1();
		s2=m.getS2();
		if(m.getA().size()>1&&m.getA().get(m.getA().size()-1).getColor().equals(m.getA().get(m.getA().size()-2).getColor()))
		{
			pl1.change1(0);
			pl1.change1(1);
			
		}
		else
		{
			pl1.change1(0);
		}
		if(m.getA1().size()>1&&m.getA1().get(m.getA1().size()-1).getColor().equals(m.getA1().get(m.getA1().size()-2).getColor()))
		{
			pl1.change2(0);
			pl1.change2(1);
			
		}
		else
		{
			pl1.change2(0);
		}
		
		if(m.getB().size()>1&&m.getB().get(m.getB().size()-1).getColor().equals(m.getB().get(m.getB().size()-2).getColor()))
		{
			pl2.change1(0);
			pl2.change1(1);
			
		}
		else
		{
			pl2.change1(0);
		}
		if(m.getB1().size()>1&&m.getB1().get(m.getB1().size()-1).getColor().equals(m.getB1().get(m.getB1().size()-2).getColor()))
		{
			pl2.change2(0);
			pl2.change2(1);
		}
		else
		{
			pl2.change2(0);
		}
			

	}
	
	
	public void focuson  (){
		this.setFocusable(true);
		this.requestFocusInWindow(); 
	}

}



















































//package work;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Random;
//import java.util.Set;
//
//import javax.imageio.ImageIO;	
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.Timer;
//
//import shapes.rectangle;
//import shapes.shape;
//
//
//
//public  class playpanel extends JPanel implements KeyListener {
//
//	static player pl1;
//	static player pl2;
//	Random randm ;
//	boolean flag=false;
//	int randnumber ; 
//	BufferedImage back;
//	pool p=pool.getPool();
//	int score1=0;
//	int score2=0;
//	static score scor1;
//	static score scor2;
//	JLabel  score1label, score2label ; 
//	static ScoreObserver s1 ;
//	static ScoreObserver s2; 
//	createmomento m;
//	int counter=0;
//	ArrayList<momento> mm;
//
//	ArrayList<shape> shapes = new ArrayList<shape>();
//	Timer time;
//	Timer time2 ; 
//	
//	public boolean isFlag() {
//		return flag;
//	}
//
//	public void setFlag(boolean flag) {
//		this.flag = flag;
//	}
//
//	public playpanel() throws IOException {
//		p.fill();
//		this.setPreferredSize(new Dimension (1680,900));
//		super.repaint();	
//		scor1=new score();
//		scor2=new score();
//		s1=new ScoreObserver() ; 
//		s1.setplayernam("player1  " );
//		s2=new ScoreObserver() ; 
//		s2.setplayernam("|| player2  " );
//
//		score1label= new JLabel () ;
//		score2label=  new JLabel (); 
//		
//		score1label.setHorizontalTextPosition(JLabel.CENTER);
//		score1label.setVerticalTextPosition(JLabel.BOTTOM);
//		score1label.setFont(new Font("Serif", Font.PLAIN, 60));
//		
//		score2label.setHorizontalTextPosition(JLabel.CENTER);
//		score2label.setVerticalTextPosition(JLabel.BOTTOM);
//		score2label.setFont(new Font("Serif", Font.PLAIN, 60));
//		
//		this.add(score1label) ; 
//		this.add (score2label); 
//		
//		randm = new Random ();
//		back = ImageIO.read(new File("back.png"));
//		pl1 = new player(1480);
//		pl1.setcolor(Color.gray);
//		pl1.flagg=true ;
//		pl2 = new player(0);
//		pl2.setcolor(Color.white);
//		pl2.flagg=false ;
//
//        m=new createmomento();
////		time = new Timer(1, new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				if(!flag)
////				{momento ls;
////				ls=new momento(pl1.getPlayershapes(),pl2.getPlayershapes(),shapes,pl1.getcheckx(),pl2.getcheckx(),s1.getPlayerscore(),s2.getPlayerscore());
////				m.ad(ls);
////				change();
////				repaint();
////				check (); 
////				}
////				else
////				{
////				mm	=m.getM();
////				pl1.setPlayershapes(mm.get(counter).getA());
////				pl2.setPlayershapes(mm.get(counter).getB());
////				shapes=(mm.get(counter).getS());
////				pl1.setx(mm.get(counter).getX1());
////				pl2.setx(mm.get(counter).getX2());
////				s1.setPlayerscore(mm.get(counter).getY1());
////				System.out.println("ssssssssssss"+mm.get(counter).getY1());
////				s2.setPlayerscore(mm.get(counter).getY2());
////				//System.out.println("ssssssssssss"+mm.get(counter).getY1());
////				s1.update(mm.get(counter).getY1());
////				s2.update(mm.get(counter).getY2());
////				repaint();
////				counter++;
////				}
////			}
////		});
//        time = new Timer(1, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				change();
//				repaint();
//				check (); 
//			}
//		});
//		time.start();
//		time2 = new Timer(750, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				s1.update(true);
//				if(!flag)
//				 {randnumber= randm.nextInt(1680) ; 
//				 fillarray();
//				 }
//			}
//		});
//		time2.start();
//		addKeyListener(this);
//	}
//
//	public void fillarray() {
//		shape temp =p.getShape();
//		temp.setX(randnumber);
//		temp.setY(0);
//		shapes.add(temp);
//		//shapes.add(new rectangle(randnumber, 0));
//	}
//
//	public void draw(Graphics2D g2d) {
//		for (int i = 0; i < shapes.size(); i++) {
//			shapes.get(i).Draw(g2d);
//		}
//	}
//
//	public void change() {
//		for (int i = 0; i < shapes.size(); i++) {
//			shapes.get(i).move();
//		}
//	}
//
//	
//	
//	public void check (){
//		for (int i=0;i<shapes.size() ;i++ ){
//			//over player1 
//			if (shapes.get(i).overplayerl(pl1)) {
//				shape temp = shapes.get(i); 
//				shapes.remove(i);
//				pl1.takeshapel(temp);
//				
//			}
//			else if (shapes.get(i).overplayerr(pl1)) {
//				shape temp = shapes.get(i); 
//				shapes.remove(i);
//				pl1.takeshaper(temp);
//				
//			}
//			//over player2 
//			else if (shapes.get(i).overplayerl(pl2)){
//				shape temp = shapes.get(i); 
//				shapes.remove(i);
//				pl2.takeshapel(temp);
//				
//			}
//			else if (shapes.get(i).overplayerr(pl2)){
//				shape temp = shapes.get(i); 
//				shapes.remove(i);
//				pl2.takeshaper(temp);
//			}
//			//out of bounds 
//			else if(shapes.get(i).checkboundary())
//			{
//				p.back(shapes.get(i));
//				shapes.remove(i);
//			}
//		}
//	}
//
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.drawImage(back, 0, 0, null);
//		
//
//		draw(g2d);
//		pl1.draw(g2d);
//		pl2.draw(g2d);
//	
//		
//		score1label.setText(String.valueOf(s1.getScore()));
//		score1label.setForeground(Color.white);
//		score2label.setText(s2.getScore());
//		score2label.setForeground(Color.gray);
//
//	}
//
//	public void addNotify() {
//		super.addNotify();
//		requestFocus();
//	}
//
//	
//
//	private final Set<Integer> pressed = new HashSet<Integer>();
//		@Override
//			public synchronized void keyPressed(KeyEvent e) {
//				pressed.add(e.getKeyCode());
//			for (int x : pressed) {
//					int keycode = e.getKeyCode();
//					
//					if ( x==37) {
//						if (pl1.x > 2) {
//							pl1.setx(pl1.getx()-10);
//						}
//						
//						repaint();
//					}
//					if (x==39) {
//						if (pl1.x < 1800) {
//							pl1.setx(pl1.getx()+10);
//						}
//						repaint();
//					}
//					if (x== 'a'|| x=='A') {
//						if (pl2.x > 2) {
//							pl2.setx(pl2.getx()-10);
//						}
//						repaint();
//					}
//					if (x== 'd' || x=='D') {
//						if (pl2.x < 1500) {
//							pl2.setx(pl2.getx()+10);
//						}
//				}
//
//			}
//
//	}
//
//	public void keyReleased(KeyEvent e) {
//		pressed.remove(e.getKeyCode());
//	}
//
//	public void keyTyped(KeyEvent e) {
//	}
//	public space save()
//	{
//	 return new space(pl1.getPlayershapesl(),pl2.getPlayershapesl(),pl1.getcheckx(),pl2.getcheckx(), s1, s2);
//	}
//	public static void load(space m)
//	{
//		pl1.setPlayershapesl(m.getA());
//		pl1.setyl(m.getA().size());
//		pl2.setPlayershapesl(m.getB());
//		pl2.setyl(m.getB().size());
//		pl1.setx(m.getX1());
//		pl2.setx(m.getX2());
//		s1=m.getS1();
//		s2=m.getS2();
//		if(m.getA().size()>1&&m.getA().get(m.getA().size()-1).getColor()==m.getA().get(m.getA().size()-2).getColor())
//		{
//			scor1.setx();
//			scor1.increment();
//			System.out.println("aaaaaaaaa"+scor1.getX());
//		}
//		else
//		{
//			scor1.setx();
//		}
//		if(m.getB().size()>1&&m.getB().get(m.getB().size()-1).getColor()==m.getB().get(m.getB().size()-2).getColor())
//		{
//			scor2.setx();
//			scor2.increment();
//			System.out.println("aaaaaaaaa"+scor2.getX());
//		}
//		else
//		{
//			scor2.setx();
//		}
//			
//
//	}
//
//}