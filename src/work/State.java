package work;

import shapes.shape;

public class State {
	player pl ; 
	shape temp ; 
	int x ; 
	int y ; 
	public State(player pl , shape temp )
	{
		this.x= temp.getX() ;
		this.y= temp.getY();
	}
	// to check player hold or not
	
	public boolean checkl()

	{
		if (/*((x>=pl.getcheckx()&&x-pl.getcheckx()<50)||*/(x<=pl.getcheckx()+10&&pl.getcheckx()+10-x>=20&&pl.getcheckx()+10-x<=60)&&y==pl.getcheckyl()){
			return true ; 
		}
		return false ;
	}
	public boolean checkr()

	{
		if ((x<=pl.getcheckx()+173&&pl.getcheckx()+173-x>=20&&pl.getcheckx()+173-x<=60)&&y==pl.getcheckyr()){
			return true ; 
		}
		return false ; 
	}
	// to check plate is lost to return it to the poll
	public boolean check2()

	{
		if (y>1400){
			return true ; 
		}
		return false ; 
	}
	
}