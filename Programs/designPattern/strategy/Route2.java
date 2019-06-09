package strategy;

import java.util.Random;

public class Route2 implements Route {

	@Override
	public String getDirection() {
		return "turn right after 150 meters ";
	}

	@Override
	public int getTotalDistance() {
		return 15;
	}

	@Override
	public String getTraffic() {
		Random random = new Random();
		if (random.nextBoolean()) {
			System.out.println("High traffic");
			return "High_Traffic";
		}
		System.out.println("low traffic");
		return "Low_Traffic";
	}

}
