package flyWeight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeight {

	Map<String, Letter> letter = new HashMap<>();

	public Letter createLetter(String key) {
		if (letter.get(key) == null) {
			letter.put(key, new Letter(key));
		}
		return letter.get(key);
	}

}
