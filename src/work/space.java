package work;

import java.io.Serializable;
import java.util.ArrayList;

import shapes.shape;

public class space implements Serializable {
    int x1;    
	int x2;
  
	ScoreObserver s1=new ScoreObserver();
	
    ScoreObserver s2=new ScoreObserver();
	ArrayList<shape> a=new ArrayList<shape>();
	ArrayList<shape> b=new ArrayList<shape>();
	ArrayList<shape> a1=new ArrayList<shape>();
	
	ArrayList<shape> b1=new ArrayList<shape>();
	public space(ArrayList <shape> a ,ArrayList<shape> b,ArrayList <shape> a1 ,ArrayList<shape> b1,int x1,int x2 ,ScoreObserver s1,ScoreObserver s2)
	{
		this.a=a;
		this.b=b;
		this.a1=a1;
		this.b1=b1;
		this.x1=x1;
		this.x2=x2;
		this.s1=s1;
		this.s2=s2;
		
	}
	public ArrayList<shape> getA() {
		return a;
	}
	public void setA(ArrayList<shape> a) {
		this.a = a;
	}
	public ArrayList<shape> getB() {
		return b;
	}
	public void setB(ArrayList<shape> b) {
		this.b = b;
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
	
	  public ScoreObserver getS1() {
			return s1;
		}
		public void setS1(ScoreObserver s1) {
			this.s1 = s1;
		}
		public ScoreObserver getS2() {
			return s2;
		}
		public void setS2(ScoreObserver s2) {
			this.s2 = s2;
		}
		public ArrayList<shape> getA1() {
			return a1;
		}
		public void setA1(ArrayList<shape> a1) {
			this.a1 = a1;
		}
		public ArrayList<shape> getB1() {
			return b1;
		}
		public void setB1(ArrayList<shape> b1) {
			this.b1 = b1;
		}
}
