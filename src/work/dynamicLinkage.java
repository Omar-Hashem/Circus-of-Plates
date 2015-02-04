package work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import shapes.shape;

public class dynamicLinkage {
	
	private URLClassLoader loader1;

	public dynamicLinkage ()
	{}
		
	@SuppressWarnings("deprecation")

	private  void copyFileUsingFileChannels(File source, File dest)
			throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

   public Class classLoader (String path,String className) { 
         	URL[] classPath = null;
        	File x = new File(path);
        	String l = x.toURI().toString();
        	if(!path.contains("bin\\shapes"))
        	{
        		String s="bin\\shapes\\"+className+".class";
        		File y = new File(s);
        		try {
					OutputStream stream = new FileOutputStream(y);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	 
				try {
					copyFileUsingFileChannels(x,y);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 l = y.toURI().toString();
        		
        	}
        	try {
				URL u = new URL(l);
				classPath = new URL[]{u};
				  System.out.println(className);
                URLClassLoader classLoader;
                classLoader = new URLClassLoader(classPath);
                Class Cl;
                String temp="shapes."+className;
				Cl = classLoader.loadClass(temp);

              
                return Cl;
                
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        	return null;
    }  

 

}
