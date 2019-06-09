package program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1 {
	  public static void main(String... args) throws Exception {
		  B b = new B();
		    ObjectOutputStream save = 
		        new ObjectOutputStream(new FileOutputStream("datafile"));
		    save.writeObject(b);
		    save.flush();
		    ObjectInputStream restore = 
		        new ObjectInputStream(new FileInputStream("datafile"));
		    B z = (B) restore.readObject();
	  }
	}
