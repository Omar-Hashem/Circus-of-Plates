package work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class saveLoad {
  public saveLoad()
  { }
  public void save(String path, String name ,space p)
  {
	    try {
	        FileOutputStream fout = new FileOutputStream(path+"\\"+name+".dat");
		      ObjectOutputStream oos = new ObjectOutputStream(fout);
		      oos.writeObject(p);
		      oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  public space load(String path)
  {
	    try {
	    	    space p;
			    FileInputStream fin = new FileInputStream(path+".dat");
			    ObjectInputStream ois = new ObjectInputStream(fin);
				p= (space) ois.readObject();
			    ois.close();
			    return p;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;

  }
  

}
