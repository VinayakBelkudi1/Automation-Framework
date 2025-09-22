package Basics;

public class Keywords {
	//Global/ static
	static int s=20;
	//Instance
	int a;
	
	public static void display() {
		//local and must be initialized
		int b=10;
		System.out.println(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Keywords.display();
		Keywords k=new Keywords();
	    
}
}