package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Random;

import javax.swing.border.StrokeBorder;

import work.player;

public class oval extends shape {
	
	public oval()
	{
		this.x=0;
		this.y=0;
		this.name="oval";
		Random rand = new Random();
		this.ser_num=rand.nextInt(3);
		setColor(ser_num);
		
	}
	@Override
	public void Draw(Graphics2D g2d) {	
		g2d.setColor(color);
		g2d.fillOval(x, y,80,20);
	    
	}

	public void move (){
		this.y+=1; 
	}
	
	
	
	public boolean overplayerl(player pl ) {
		if (/*((x>=pl.getcheckx()&&x-pl.getcheckx()<50)||*/(x<=pl.getcheckx()+10&&pl.getcheckx()+10-x>=20&&pl.getcheckx()+10-x<=60)&&y==pl.getcheckyl()){
			return true ; 
		}
		return false ;
	}
	public boolean overplayerr(player pl ) {
		if ((x<=pl.getcheckx()+173&&pl.getcheckx()+173-x>=20&&pl.getcheckx()+173-x<=60)&&y==pl.getcheckyr()){
		return true ; 
	}
	return false ; 
	}
	public boolean checkboundary() {
		if (y>1400){
			return true ; 
		}
		return false ; 
	}
	

}
