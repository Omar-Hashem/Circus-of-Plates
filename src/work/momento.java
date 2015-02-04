package work;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import shapes.shape;

public class momento {
	
	public ArrayList<shape>s;

	public ArrayList<shape>A;
	public ArrayList<shape>B;
	int x1,x2;
	Integer y1,y2;
	public ArrayList<shape>A1;

	public ArrayList<shape>B1;


	public momento(ArrayList <shape>A ,ArrayList<shape>B,ArrayList<shape>s,ArrayList <shape>A1 ,ArrayList <shape>B1 , int x1,int x2 ,Integer y1,Integer y2){
		    this.A=(ArrayList<shape>) copy(A);
		    this.B=(ArrayList<shape>) copy(B);
		    this.A1=(ArrayList<shape>) copy(A1);
		    this.B1=(ArrayList<shape>) copy(B1);
			this.s=(ArrayList<shape>) copy(s);
			this.y1=(Integer) copy(y1);
			this.y2=(Integer) copy(y2);
			this.x1=x1;
			this.x2=x2;
	}
	
	public ArrayList<shape> getS() {
		return s;
	}
	public void setS(ArrayList<shape> s) {
		this.s = s;
	}
	public ArrayList<shape> getA() {
		return A;
	}

	public void setA(ArrayList<shape> a) {
		A = a;
	}

	public ArrayList<shape> getB() {
		return B;
	}

	public void setB(ArrayList<shape> b) {
		B = b;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}
	public Integer getY1() {
		return y1;
	}

	public void setY1(Integer y1) {
		this.y1 = y1;
	}

	public Integer getY2() {
		return y2;
	}

	public void setY2(Integer y2) {
		this.y2 = y2;
	}
	 public static Object copy(Object object) {
	       
	        try {
	        	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        	     ObjectOutputStream oos = new ObjectOutputStream(baos);
	        	     oos.writeObject(object);
	        	     ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	        	     ObjectInputStream ois = new ObjectInputStream(bais);
	        	     return ois.readObject();
	         

	          
	        }
	        catch(Throwable e) {
	            e.printStackTrace();
	        }
	  return null;
	    }
		public ArrayList<shape> getA1() {
			return A1;
		}

		public void setA1(ArrayList<shape> a1) {
			A1 = a1;
		}

		public ArrayList<shape> getB1() {
			return B1;
		}

		public void setB1(ArrayList<shape> b1) {
			B1 = b1;
		}

}
