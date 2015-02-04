package work;

import java.util.ArrayList;
import java.util.Random;
import shapes.shape;

public class pool {
	private static pool instance    = new pool();
	shapesFactory factory =new shapesFactory ();
	ArrayList<shape> store=new ArrayList<shape>();
	ArrayList<shape> product=new ArrayList<shape>();
	Random rand =new Random();
	private pool(){}
	public static pool getPool() {
		return instance ;
	}

	public void fill()
	{
		
		for(int i=0;i<1000;i++)
		{		
			store.add(factory.getshape(rand.nextInt(factory.getRandom())));
		}
	}
	public shape getShape()
	{
	 	if(store.isEmpty())
	    { 
			shape temp=factory.getshape(rand.nextInt(factory.getRandom()));
			product.add(temp);
			return temp;
		}
	 	else
	 	{
	 		shape temp=store.remove(store.size()-1);
	 		product.add(temp);
	 		return temp;
	 	}
		
	}
	public void back(shape c)
	{
		product.remove(c);
		store.add(c);
	}
	public int getsize()
	{
		return store.size();
	}

}
