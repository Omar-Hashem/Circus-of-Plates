package work;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import shapes.shape;


public class player  implements  Serializable  {
	BufferedImage pi ;
	ArrayList <shape> playershapesl = new ArrayList <shape> ();
	ArrayList <shape> playershapesr = new ArrayList <shape> (); 
	
	pool p = pool.getPool() ; 
	score scorel ; 
	score scorer; 
	Color arms  ; 
	public  int x ;
	int checkx ; 
	
	public boolean flagg=false   ; 
	int checkyl=650; 
	int checkyr=650; 

	public player (int x ) throws IOException{
		this.x= x; 
		checkx= x ; 
		scorel=new score () ; 
		scorer=new score () ;
		pi= ImageIO.read(new File ("clown.png")) ; 
		
	}
	
	
	void change1(int x)
	{
		System.out.println("heeeeeeeeee"+playershapesl);
		if(x==0)
			scorel.setx();
		else
			scorel.increment();
	}
	void change2(int x)
	{
		System.out.println("heeeeeeeeee"+playershapesr);
		if(x==0)
			scorer.setx();
		else
			scorer.increment();
	}
	public void setcolor(Color c ){
		this.arms = c; 
	}
	public void draw (Graphics2D g2d ){
		g2d.drawImage(pi,x,670,null ) ;
		g2d.setColor(arms);
		g2d.fillRect(x+10, 670, 10, 80);
		g2d.fillRect(x+173,670, 10, 130);
		for (int i=0;i<playershapesl.size() ;i++ ){
			playershapesl.get(i).Draw(g2d);
		}
		for (int i=0;i<playershapesr.size() ;i++ ){
			playershapesr.get(i).Draw(g2d);
		}
	}
	
	
	public void takeshapel (shape temp ){
		
		if(this.sizeofl()>0&&temp.getColor().equals(this.perviousl().getColor())){
			scorel.increment();
		}
		else {
			scorel.setx();
		}
		playershapesl.add(temp) ; 
		if(scorel.check())
		{
			//notify1
			if (!flagg){
				view.s1.update(true);
				
			}
			else {
				view.s2.update(true);
			}
			scorel.setx();;
			p.back(this.getshapel(this.sizeofl()-1));
			p.back(this.getshapel(this.sizeofl()-2));

			p.back(this.getshapel(this.sizeofl()-3));
			this.removel();				
		}
		System.out.println(playershapesl);
		checkyl-=20 ; 
	}
	public void takeshaper(shape temp ){
		if(this.sizeofr()>0&&temp.getColor().equals(this.perviousr().getColor())){
			scorer.increment();
		}
		else {
			scorer.setx();
		}
		playershapesr.add(temp) ; 
		if(scorer.check())
		{
			//notify1
			if (!flagg){
				view.s1.update(true);

			}
			else {
				view.s2.update(true);

			}
			scorer.setx();;
			p.back(this.getshaper(this.sizeofr()-1));
			p.back(this.getshaper(this.sizeofr()-3));
			this.remover();				
		}
		System.out.println(playershapesr);
		checkyr-=20 ; 
	}
	
	public shape  perviousl()
	{
		return playershapesl.get(playershapesl.size()-1);
	}
	public shape  perviousr()
	{
		return playershapesr.get(playershapesr.size()-1);
	}
	
    public int sizeofl()
    {
    	return playershapesl.size();
    }
    public int sizeofr()
    {
    	return playershapesr.size();
    }
  
	public ArrayList<shape> getPlayershapesl() {
		return playershapesl;
	}
	public ArrayList<shape> getPlayershapesr() {
		return playershapesr;
	}

	public void setPlayershapesl(ArrayList<shape> playershapesl) {
		this.playershapesl = playershapesl;
	}
	
	public void setPlayershapesr(ArrayList<shape> playershapesr) {
		this.playershapesr= playershapesr;
	}
    public void removel()
    {
    	playershapesl.remove(playershapesl.size()-1);
    	playershapesl.remove(playershapesl.size()-1);
    	playershapesl.remove(playershapesl.size()-1);
    	checkyl+=(3*20);
    }
    
    public void remover()
    {
    	playershapesr.remove(playershapesr.size()-1);
    	playershapesr.remove(playershapesr.size()-1);
    	playershapesr.remove(playershapesr.size()-1);
    	checkyr+=(3*20);
    }
    
	public int getx (){
		return this.x ;
	}
	public shape getshapel(int i)
	{
		return playershapesl.get(i);
	}
	public shape getshaper(int i)
	{
		return playershapesr.get(i);
	}
	public void setx (int newx ){
		System.out.println(newx);
		int tmp = this.x ; 
		this.x=newx ; 
		checkx=newx ;
		for (int i=0;i<playershapesl.size();i++ ){
			playershapesl.get(i).setX(newx-26);
		}
		for (int i=0;i<playershapesr.size();i++ ){
			playershapesr.get(i).setX(newx+138);
		}
	}
	public void setyl(int x)
	{
		checkyl=650-x*20;
	}
	public void setyr(int x)
	{
		checkyr=650-x*20;
	}
	public int getcheckx (){
		return this.checkx; 
		
	}
	
	
	public int getcheckyl (){
		return this.checkyl ; 
	}
	public int getcheckyr(){
		return this.checkyr ; 
	}
	
	
}
