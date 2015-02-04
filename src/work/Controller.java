package work;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller  extends JFrame {
	
	
	
	
	public Controller (){
		startpanel p = new startpanel ();
		this.add(p) ; 

		this.setVisible(true ) ;
		this.pack();
//		this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void newgamef () throws IOException{
		window w= new window (); 
		this.dispose();
	}
	
	public void closefun (){
		this.dispose ( ); 
	}
	public void loadgamef () throws IOException{
		String filepath = openfilechooser (); 
		if (filepath!="cancel"){
			window w = new window () ;
			filepath= filepath.replaceAll(".dat", "") ; 
			saveLoad s =new saveLoad();
			view.load(s.load(filepath));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String openfilechooser () {
		JFrame  parent = new JFrame () ;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "dat files", "dat");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		   return chooser.getSelectedFile().getPath();
		}
		return "cancel" ;
	}
	
	
	///panel class 
	
	public class startpanel extends JPanel  {
	JButton newgame ; 
	JButton loadgame ; 
	JButton exit ; 
	
	Timer time; 
	
	String[]  photos = {"logo1.png","logo2.png","logo3.png","logo4.png","logo5.png","logo6.png"} ; 
	String photo = "logo1.png" ; 
	int index=0 ; 
	public startpanel (){
		
		super.repaint ();
		this .setLayout(null ) ;
		
		this.setPreferredSize(new Dimension(1250,600));
		ImageIcon newgamei  = new ImageIcon("newgame.png");
		newgame  = new JButton (newgamei); 
		newgame.setBackground(Color.WHITE);
		newgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					newgamef();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
			}
		});
		
		
		
		ImageIcon loadgamei = new ImageIcon("loadgame.png");
		loadgame = new JButton(loadgamei); 
		loadgame.setBackground(Color.WHITE);

		loadgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadgamef ();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		});
		
		
		
		ImageIcon exiti = new ImageIcon("exit.png");
		exit = new JButton(exiti); 
		exit.setBackground(Color.WHITE);

		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				closefun () ;
			}
		});
		
		
		time = new Timer (50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				index=(index+1)%6; 
				photo = photos[index] ;
				repaint() ; 
			}
		}) ;
		
		
		newgame.setBounds(1000,200, 140, 45);
		loadgame.setBounds(1000,300,140,45);
		exit.setBounds(1000,400 ,140 ,45);
		this.add(newgame) ; 
		this.add(loadgame); 
		this.add(exit); 
		time.start() ;
	}
	
	
	public void paintComponent (Graphics g ){
		super.paintComponent(g);
		Graphics2D g2d=  (Graphics2D) g; 
		try {
			draw(g2d) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void draw (Graphics2D g2d ) throws IOException{
		BufferedImage back = ImageIO.read(new File (photo)) ; 
		BufferedImage background = ImageIO.read(new File ("background.png")) ;
		g2d.drawImage(background, 0,0,null ); 
		g2d.drawImage(back , 300,200, null); 
	}
	}
}
