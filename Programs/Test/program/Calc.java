package program;

public class Calc extends Mid {
	public static void main(String[] args) {
		int n1 = 22, n2 = 2;
//		Calc c = new Calc(); int n3 = c.findMid(n1,n2);
//		int n3 = super.findMid(n1,n3);
//		Calc c = new Mid(); int n3 = c.findMid(n1, n2);
		
		Mid m = new Mid();
		Calc c =new Calc();
		Calc1 c1 =new Calc1();
		m=c;
		c1= m;
		c = (Calc) m;
		c1 = (Calc1)c;
		int n3 = m.findMid(n1, n2);
		System.out.print(n3);
	}
}
