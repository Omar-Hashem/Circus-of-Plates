package work;

import java.awt.Color;

public class score {
	int x;
	
	public score(){x=0;}
	public boolean check()
	{
		if(x==2)
		{
			x=0;
			return true;
		}
		return false;
	}
	public int getX() {
		return x;
	}
	public void increment() {
		x++;
	}
	public void setx()
	{
		x=0;
	}
	
	

}
