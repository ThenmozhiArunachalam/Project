package main;

public class MethodOverloading {

	public static void main(String args[]) {
		print(2);

		// example for autoboxing
		print(new Integer(2));
		print(new Long(2));

		// example for unboxing..here Integer unboxing to int.
		display(2);
		display(new Integer(2));

		// Example for more specific selection first child(string method) and then
		// super(Object) class
		show1(null);

		// This Error is for null is accepted both String and Integer. Because these are
		// non primitive data types.so the compiler get confused which one should take
		// to execute
		display1(null);

		// example for widening it is same as display method for int..
		// there Integer unboxing to int.. Here Long widening to float
		show(2);
		show(new Long(2));

		// Example for boxing and then widening. here we have only view(long) method
		// only.
		// so first int autoboxing to Integer. and then Integer widening to Object
		int i = 2;
		view(i);

		// Example for var-args and widening.. even var- args method int is present, still
		// it widening to long
		view(i, i);

	}
	
	private static void print(Long long1) {
		System.out.println("Long method");
	}

	private static void print(int i) {
		System.out.println("int method");
	}

	private static void print(Integer i) {
		System.out.println("Integer method");
	}

	private static void print(Object i) {
		System.out.println("Object method");
	}

	private static void display(int i) {
		System.out.println("int method");
	}

	private static void show1(String object) {
		System.out.println("String method");
	}

	private static void show1(Object object) {
		System.out.println("String method");
	}

	private static void display1(Integer object) {
		System.out.println("String method");
	}

	private static void display1(String object) {
		System.out.println("String method");
	}

	private static void show(float object) {
		System.out.println("float method");
	}

	private static void show(int i) {
		System.out.println("int method");
	}

	private static void view(Object i) {
		System.out.println("Object method : Autoboxing and widening");
	}

	private static void view(int... i) {
		System.out.println("var method");
		// This syntax tells the compiler that fun( ) can be called with zero or more
		// arguments. As a result, here a is implicitly declared as an array of type int[].
		/* static void fun(int ...a)
		 {
		 System.out.println("Number of arguments: " + a.length);
		
		 // using for each loop to display contents of a
		 for (int i: a)
		 System.out.print(i + " ");
		 System.out.println();
		 }*/
		
		/*Specifying two varargs in a single method:
			void method(String... gfg, int... q)
			{
			    // Compile time error as there are two
			    // varargs
			}
			Specifying varargs as the first parameter of method instead of last one:
			void method(int... gfg, String q)
			{
			    // Compile time error as vararg appear
			    // before normal argument
			}*/
	}

	private static void view(long i, long j) {
		System.out.println("long method");
	}
	
	/*@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
         Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false 
        if (!(o instanceof Complex)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Complex c = (Complex) o; 
          
        // Compare the data members and return accordingly  
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0; 
    } */
}
