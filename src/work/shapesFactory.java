package work;

import java.io.File;
import java.util.ArrayList;

import shapes.shape;

public class shapesFactory {
	public ArrayList<Class>loadClasses;
	public int counter;
	public shapesFactory()
	{
		System.out.println("here");
		  String files;
		  File folder = new File("bin\\shapes");
		  File[] listOfFiles = folder.listFiles(); 
		  loadClasses =new ArrayList <Class>(); 
		  dynamicLinkage link=new dynamicLinkage();
		  counter=0;
		  for (int i = 0; i < listOfFiles.length; i++) 
		  {
		 
		   if (listOfFiles[i].isFile()) 
		   {
		   files = listOfFiles[i].getName();
		       if (files.endsWith(".class") && !files.contains("shape"))
		       {
		          loadClasses.add(link.classLoader("bin\\shapes"+files.replace(".class","")+".class", files.replace(".class","")));
		          counter++;
		        }
		     }
		  }
		}
	
	
	public shape getshape(int random)
	{
		try {
			return (shape)loadClasses.get(random).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getRandom()
	{
		return counter;
	}
	
		
	}


