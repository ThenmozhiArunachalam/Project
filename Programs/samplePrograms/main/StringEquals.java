package main;

/**
 * Whenever we create a String Object, two objects will be created i.e. One in
 * the Heap Area and One in the String constant pool and the String object
 * reference always points to heap area object.
 */
public class StringEquals {
	public static void main(String args[]) {

		String ans;

		String s = "Test";
		String s1 = s;

		/* because of string pool it refers the same object; == checks the reference
		 							String Pool
	     			s -----------------> "test" <-----------------s1*/
		ans = (s == s1) ? "YES" : "NO";
		System.out.println(ans);

		 /*here new ref created
		  				String Pool
		     "test" <-------------------- a

		                   Heap
		     "test" <-------------------- b*/
		String s2 = new String(s);
		ans = (s == s2) ? "YES" : "NO";
		System.out.println(ans);
		
		/**
		 * Here s3,s8 pointing to heap(ref) and s4 pointing to String Constant Pool(SCP)  
		 */
		// S3 refers to Object in the Heap Area 
		String s3 = new String("GFG"); // Line-1 
        // S4 refers to Object in the Heap Area 
        String s4 = s3.intern(); // Line-2 
        String s8 = s3;
        System.out.println(s3 == s4); 
        System.out.println(s3 == s8); 
        // S5 refers to Object in the SCP Area 
        String s5 = "GFG"; // Line-3 
        System.out.println(s4 == s5); 
        
        String s6 = "GFG1"; // Line-1 
        String s7 = s6.intern(); // Line-2 
        System.out.println(s6 == s7); 
		
	}
}
