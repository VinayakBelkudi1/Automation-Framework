package Basics;

public class Var_Op_Control {
	//Variable a is location name in memory where you are storing data
	//the value stored in a can change during program
	int age;
	float f=age;   //widening conversion
	int j =(int) f;// narrowing conversion
	char c='5';
	int k=c;
	
	
	Var_Op_Control(){
		this.age=20;
	}
	
	//"add" is identifier to identify below method entity anywhere in program
	public int add(int x, int y) {
		return x+y;
	}
	
	
	public static void main (String[] args) {
		//Here v is reference variable which will store the address of the new object created but not the values present in object
		Var_Op_Control v=new Var_Op_Control();
		System.out.println(v.k); //Prints ASCII value  (A-Z 65 to 90 a-z 97 to 122)
		
		if(v.age>18) {
			System.out.println("Adult");
		}
		else {
			System.out.println("Minor");
		}
		switch (v.c) {
		case 'A':System.out.println("Capital A");
		break;
		case 'a':System.out.println("Small a");
		break;
		default:System.out.println("Its not alphabet");
		
		}
		//Reference array concept
		Var_Op_Control [] vars=new Var_Op_Control[2];
		Var_Op_Control v1=new Var_Op_Control();
		Var_Op_Control v2=new Var_Op_Control();
		vars[0]=v1;
		vars[1]=v2;
		
		for(Var_Op_Control obj:vars) {
			Var_Op_Control vobj=obj;
			System.out.println(vobj.age);
			
		}
			
	}
	
	

}
