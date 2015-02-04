package work;
import java.util.ArrayList;
public class createmomento {
	public ArrayList <momento> m;

	public createmomento()
	{
		m=new  ArrayList <momento>();
	}
	public ArrayList<momento> getM() {
		return m;
	}
	public void ad(momento k) {
		m.add(k);
	}
 
}
