package main;

public class StringContainVowels {
	public static void main(String args[]) {
		String str = "aeiou";
		String val = "applewap";
		String a[] = val.split("");
		String b = "";
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (str.contains(a[i])) {
				str= str.replace(a[i], "");
				b = a[i];
				count++;
				if (count == 2) {
					System.out.println("Yes");
					return;
				}
			} else {
				str.concat(b);
				count = 0;
			}
		}
		System.out.println("No");
	}

}
