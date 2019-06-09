package main;

public class SimplePOJO {

	private int id;
	private String name;

	public SimplePOJO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "SimplePOJO [id=" + id + ", name=" + name + "]";
	}

	public int getCalculation(int id) {
		int ans = id * id;
		System.out.println(ans);
		return ans;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int add(int a, int b) {
		return (a + b);
	}

}

class POJO2 {
	
}
