package program;

public class TestOuter
{
	public void myOuterMethod()	{
		new TestOuter().new TestInner();
	}
	public class TestInner { }
	public static void main(String[] args) {
		TestOuter to = new TestOuter();
		System.out.println(to.toString());
	}
}