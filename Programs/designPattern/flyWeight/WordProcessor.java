package flyWeight;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {

	List<Letter> letters=new ArrayList<>();
	
	public void addLetter(Letter letter) {
		letters.add(letter);
	}
	
	public void printLetters() {
		for(Letter letter:letters) {
			System.out.print(letter.getValue());
		}
	}
}
