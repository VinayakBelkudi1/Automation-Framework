package oops;

public class Inheritance {

	int a=10;
	
	public void display() {
		System.out.println(a);
	}
}

 class Child extends Inheritance{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c=new Child();
		c.display();
	}

}
