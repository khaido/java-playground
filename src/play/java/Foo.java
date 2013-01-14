package play.java;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Foo {

    private static final Logger logger =  LoggerFactory.getLogger(
    		Foo.class);    	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Logger logger = LoggerFactory.getLogger(Foo.class);
//		logger.setLevel(Level.INFO);
		
//		Animal animal;
//		animal = new Dog("fido");
//		animal.speak();
//		
//		animal = new Cat("moon");
//		animal.speak();

		
		logger.debug("My first log");
		logger.info("My first log");

	}

}
