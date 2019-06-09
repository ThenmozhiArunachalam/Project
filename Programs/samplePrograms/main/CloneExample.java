package main;

/*1)If we use assignment operator to assign an object reference to another reference variable 
    then it will point to same address location of the old object and no new copy of the object
    will be created. Due to this any changes in reference variable will be reflected in original object.
    
 2)If we use copy constructor, then we have to copy all of the data over explicitly i.e. we have to 
   reassign all the fields of the class in constructor explicitly. But in clone method this work of 
   creating a new copy is done by the method itself.So to avoid extra processing we use object cloning.
*/
public class CloneExample {

	public static void main(String args[]) throws CloneNotSupportedException {

		CloneTest shallowTest1 = new CloneTest();
		System.out.println("befole clone test1 " + shallowTest1.toString());

		CloneTest shallowTest2 = (CloneTest) shallowTest1.clone();
		System.out.println("After clone test2 " + shallowTest2.toString());

		System.out.println("Shallow test------------ ");
		// now change the cloned object... it will reflect the original object too.
		shallowTest2.setX(500); // this class have the clone method.. so it is not reflected to original object
		shallowTest2.shallow.setI(300); // this class not have clone method. so it create another object with same ref.
		System.out.println("After changing clone test1 " + shallowTest1.toString());
		System.out.println("After changing clone test2 " + shallowTest2.toString());

		System.out.println("Deep test------------ ");
		// now change the cloned object... it will not reflect the original object too.
		shallowTest2.setX(600); // this class have the clone method.. so it is not refelected to original object
		shallowTest2.deep.setI(800); // this class also have the clone method. so it create the another object with
										// another ref.
		System.out.println("After changsing  clone test1 " + shallowTest1.toString());
		System.out.println("After changing clone test2 " + shallowTest2.toString());

	}
}

class ShallowClone {

	int i = 5, j = 10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "ShallowClone [i=" + i + ", j=" + j + "]";
	}

}

class CloneTest implements Cloneable {

	int x = 15, y = 20;

	ShallowClone shallow = new ShallowClone();

	DeepClone deep = new DeepClone();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ShallowClone getShallow() {
		return shallow;
	}

	public void setShallow(ShallowClone shallow) {
		this.shallow = shallow;
	}

	public DeepClone getDeep() {
		return deep;
	}

	public void setDeep(DeepClone deep) {
		this.deep = deep;
	}

	@Override
	public String toString() {
		return "CloneTest [x=" + x + ", y=" + y + ", shallow=" + shallow + ", deep=" + deep + "]";
	}

	// here no clone called for sallow object
	@Override
	protected Object clone() throws CloneNotSupportedException {
		CloneTest cloneTest = (CloneTest) super.clone();
		cloneTest.deep = (DeepClone) deep.clone();
		return cloneTest;
	}

}

class DeepClone implements Cloneable {

	int i = 5, j = 10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "DeepClone [i=" + i + ", j=" + j + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
