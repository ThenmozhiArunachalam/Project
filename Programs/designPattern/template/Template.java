package template;

public abstract class Template {

	/** have the template for execution */
	public void readProcessSave() {
		readData();
		processData();
		saveData();
	}

	public abstract void readData();

	public abstract void processData();

	public void saveData() {
		System.out.println("saved data successfully");
	}

}
