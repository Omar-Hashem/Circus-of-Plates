package shapes;
import java.awt.Graphics;
import java.awt.Graphics2D;





import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import work.*;

public abstract class shape extends JComponent {
	
	public int x ,y;
	public Color color;
	public int ID;
	public String name ;
	public int ser_num;
	String state ; 
	State s ; 
	
	public abstract void Draw(Graphics2D g2d) ;
	public abstract void move (); 
	public abstract boolean overplayerl (player pl );
	public abstract boolean overplayerr(player pl );

	public abstract boolean checkboundary();
//	public abstract void setState (); 

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(int choice) {
		switch(choice)
		{
		case 0:
			color= Color.red;
			break;
		case 1:
			color=Color.blue;
			break;
		case 2:
			color=Color.green;
		
		}
	}
	public int getSer_num() {
		return ser_num;
	}
	public void setSer_num(int ser_num) {
		this.ser_num = ser_num;
	}
	
	public void  setID(int ID)
	{
		this.ID=ID;
	}
	public int getID()
	{
		return this.ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean check (shape upper)
	{
		if(this.ser_num==upper.getSer_num())
			return true;
		return false;
	}
	

}
//public abstract class Shape {
//
//	public abstract void draw (Graphics2D g2d ) ; 
//	public abstract void move (); 
//
//}
