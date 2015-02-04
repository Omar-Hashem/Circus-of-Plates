package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import work.*;


public class rectangle extends shape  {

	public rectangle ( ){
		this.x = 0 ; 
		this.y=0; 
		this.name="rectangle";
		Random rand = new Random();
		this.ser_num=rand.nextInt(3);
		setColor(ser_num);
		
	}
	@Override
	public void Draw(Graphics2D g2d) {
		
//	    g2d.setColor(Color.black);
//	    Rectangle rect2 = new Rectangle(0, 0, 200, 200);
//	    g2d.draw(rect2);
//	    g2d.fill(rect2);	
		g2d.setColor(color);
		g2d.fillRect(x, y,80,20);
	    
	}

	public void move (){
		this.y+=1; 
	}
	
	
	
	public boolean overplayerl(player pl ) {
		if (/*((x>=pl.getcheckx()&&x-pl.getcheckx()<50)||*/(x<=pl.getcheckx()+10&&pl.getcheckx()+10-x>=20&&pl.getcheckx()+10-x<=60)&&y==pl.getcheckyl()){
			return true ; 
		}
		return false ;
//		s=new State (pl,this ) ;
//		return s.checkl();
	}
	public boolean overplayerr(player pl ) {
		if ((x<=pl.getcheckx()+173&&pl.getcheckx()+173-x>=20&&pl.getcheckx()+173-x<=60)&&y==pl.getcheckyr()){
			return true ; 
		}
		return false ; 
	}
	public boolean checkboundary( ) {
		if (y>1400){
			return true ; 
		}
		return false ; 
	}
	
	
	
	

	
	
	
}
