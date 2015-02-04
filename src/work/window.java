package work;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

//
//
//
//public class window extends JFrame {
//
//	JButton save  ;
//	JButton replay ; 
//	JButton pause ; 
//	JButton resume ; 
//	JButton exit ; 
//	public window () throws IOException{
//		playpanel ppanel = new playpanel ();
//		this.setLayout(new BorderLayout());
//		this.add(ppanel, BorderLayout.CENTER); 
//		focuson (ppanel);
//		this.setVisible(true ) ;
//		this.pack();
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//	
//	
//	
//	public void setButtons (){
//		JPanel p = new 
//		this.setLayout(null);
//		save = new JButton("save")  ;
//		save .setBounds(200,10,120,40);
//		save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		} );
//		this.add(save) ; 
//		
//		replay = new JButton() ; 
//		replay .setBounds(250,10,120,40);
//		replay.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		} );
//		this.add(replay); 
//		
//		pause = new JButton() ; 
//		pause .setBounds(300,10,120,40);
//		pause.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		} );
//		this.add(pause ); 
//		
//		resume = new JButton() ; 
//		resume .setBounds(350,10,120,40);
//		resume.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//			}
//		} );
//		this.add(resume ); 
//		
//		
////		exit = new JButton() ; 
////		exit .setBounds(400,10,120,40);
////		exit.addActionListener(new ActionListener() {
////			
////			@Override
////			public void actionPerformed(ActionEvent arg0) {
////				focuson () ;
////			}
////		} );
////		this.add(exit); 
//		
//		
//	}
//	public void focuson  (JPanel p){
//		p.setFocusable(true);
//		p.requestFocusInWindow(); 
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//


























public class window extends JFrame {


	JButton save  ;
	JButton replay ; 
	JButton pause ; 
	JButton resume ; 
	JButton newgame ;
	JButton exit ;
	
	JButton load   ;


//	JButton exit ; 
	public window () throws IOException{
		setButtons ();
		this.setVisible(true ) ;
		this.pack(); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void df (){
		this.dispose();
	}
	public ArrayList  savefilechooser (){
		ArrayList<String> file  = new ArrayList () ;
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    String tmp =  fileToSave.getParent();
		    String tmp2 = fileToSave.getName() ; 
		    file.add(tmp) ; 
			file.add(tmp2); 
		    System.out.println(tmp2 );
		}
		return file ; 
		
	}
	public void setButtons () throws IOException{
		final view ppanel = new view ();
		final JPanel bpanel = new JPanel (); 

		

		pause = new JButton ("pause") ; 
//		pause.setBounds(200, 10, 120, 40);
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ppanel.time.stop();
				ppanel.time2.stop();
				focuson(bpanel) ;
			}
		});
		
		resume = new JButton ("resume") ; 
//		resume.setBounds(200, 10, 120, 40);
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ppanel.time.restart();
				ppanel.time2.restart();
				focuson(ppanel); 
			}
		});
		
		replay = new JButton ("replay"); 
//		replay.setBounds(200, 10, 120, 40);
		replay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ppanel.setFlag(true);
			}
		});
		save = new JButton ("save"); 
//		save.setBounds(0, 0, 120, 40);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String>  file = new ArrayList <String>(); 
				file = savefilechooser(); 
				saveLoad s =new saveLoad();
				s.save((String )file.get(0), (String)file.get(1), ppanel.save());
				focuson (ppanel); 
				
			}
		});
		newgame = new JButton ("new game"); 
		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					df();
					window w =new window ();
					focuson(ppanel); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		exit = new JButton ("exit"); 
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df(); 
			}
		});
		
		
		load  = new JButton ("load "); 
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.setLayout(new BorderLayout());
//		bpanel.setLayout(null );
		bpanel.setBackground(Color.darkGray);
		
		bpanel.add(pause); 
		bpanel.add(resume); 
		bpanel.add(replay);
		bpanel.add(save);
		bpanel.add(newgame) ;
		bpanel.add(exit); 
		
		

		
		this.add(bpanel,BorderLayout.NORTH);  
		this.add(ppanel, BorderLayout.CENTER); 
		focuson (ppanel); 		
	}
	public void focuson  (JPanel p){
		p.setFocusable(true);
		p.requestFocusInWindow(); 
	}
	
	
}













//public window (){
//	startpanel p = new startpanel ();
//	this.add(p) ; 
//
//	this.setVisible(true ) ;
//	this.pack();
////	this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//}