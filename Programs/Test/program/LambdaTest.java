package program;

public class LambdaTest {
	public static void main(String ﬂargs) {
		String word = "hello";
		SuﬁixFunction suﬁixFunc = () -> System.out.println(word + "ay");
		word = "e";
		suﬁixFunc.call();
	}
}
