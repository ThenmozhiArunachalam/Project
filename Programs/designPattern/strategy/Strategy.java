package strategy;

/**
 * subclass to decide which class to execute. 
 * factory pattern is to create, Strategy is to perform an action.
 */

public class Strategy {

	Route route;

	public Strategy() {
		route = getBestPattern();
	}

	private Route getBestPattern() {
		Route1 route1 = new Route1();
		Route2 route2 = new Route2();
		if (route1.getTraffic().equals("Low_Traffic"))
			return route1;
		return route2;
	}

	public void getNavigate() {
		String direction = route.getDirection();
		System.out.println(direction);
	}

}
