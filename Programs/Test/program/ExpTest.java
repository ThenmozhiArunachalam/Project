package program;

public class ExpTest {
	static void testException() throws RuntimeException {
		try {
			System.out.print("testException ");
			throw new RuntimeException();
		} catch (Exception ex) {
			System.out.print("Exception ");
		}
	}

	public static void main(String[] args) {
		try {
			testException();
		} catch (RuntimeException ex) {
			System.out.print("runtime ");
		}
		System.out.print("end ");
	}
}
