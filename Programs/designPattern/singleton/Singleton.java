package singleton;

/** to make a class Singleton 3 points to remember 
 * Ex : Logger and device printer
 */

public class Singleton {

	/* 1. make constructor as a private */
	private Singleton() {

	}

	/* 2. create a singleton object */
	private static Singleton singleteon = null;

	/* 3. make this method as Static. Then only we need to create a objcet to access
	 * this method
	 */
	public static Singleton getInstance() {
		if (singleteon == null) {
			singleteon = new Singleton();
		}
		return singleteon;

	}

}
