package main;

public class SimpleFunInterfaceTest {
	public static void main(String[] args) {
		FuntionalInterface i = () ->{System.out.println("Do work in lambda exp impl...");};
		i.doWork();
		
		carryOutWork(() -> System.out.println("Do work in lambda exp impl..."));
	}

	public static  void carryOutWork(FuntionalInterface sfi) {
		sfi.doWork();
		sfi.display();
	}
}
