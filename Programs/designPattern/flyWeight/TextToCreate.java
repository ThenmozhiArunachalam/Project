package flyWeight;

/**
 * to reuse already existing similar kind of objects by storing them and create
 * new object when no matching object is found
 */
public class TextToCreate {

	private WordProcessor processor = new WordProcessor();

	public void create(String textToAdd) {
		for (int i = 0; i < textToAdd.length(); i++) {
			String value = textToAdd.substring(i, i + 1);
			processor.addLetter(new Letter(value));
		}
		processor.printLetters();
	}

	public void createWithFlyWeight(String textToAdd) {
		FlyWeight flyweight = new FlyWeight();
		for (int i = 0; i < textToAdd.length(); i++) {
			String value = textToAdd.substring(i, i + 1);
			processor.addLetter(flyweight.createLetter(value));
		}
		processor.printLetters();
	}

}
