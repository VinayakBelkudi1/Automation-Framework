package Basics;

import oops.Encpasulation;

public class Constructors {
	
		int a;
		int b;
		//No need to write default constructor
		
		//Non argument constructor
		public Constructors() {
			this.a=10;
			this.b=20;
		
		}
		
		//Parameterized constructor
		public Constructors(int x, int y){
			this.a=x;
			this.b=y;
		}
		
		//Copy constructor
		
		public Constructors(Constructors c) {
			this.a=c.a;
			this.b=c.b;
		}
		
		public void display() {
			System.out.println("vale of a "+this.a);
			System.out.println("value of b " +this.b);
		}
		//Instance block
		{
			
		}
		public Constructors(int a) {
			this(1,2);
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructors[] carray=new Constructors[3];
		
		Constructors c0=new Constructors();
		Constructors c1=new Constructors(100, 200);
		Constructors c2=new Constructors(c1);
		
		carray[0]=c0;
		carray[1]=c1;
		carray[2]=c2;
		
		for(Constructors obj: carray) {
			
			obj.display();
			System.out.println("\n");
		}
		
		Encpasulation e=new Encpasulation();
		e.getA123();

	}

}
