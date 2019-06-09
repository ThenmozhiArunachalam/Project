package strategy;

import java.util.Random;

public class Route1 implements Route {

	@Override
	public String getDirection() {
		return "Turn left after 200 meters";
	}

	@Override
	public int getTotalDistance() {
		return 20;
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
