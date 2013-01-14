package play.java;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void speak(){
		System.out.println( "meow!");
	}

}
