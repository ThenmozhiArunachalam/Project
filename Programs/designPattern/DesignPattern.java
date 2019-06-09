import adapter.Bus;
import adapter.Car;
import adapter.Vehicle;
import adapter.VehicleAdapter;
import adapter.Walk;
import bridge.Assemble;
import bridge.Bike;
import bridge.Bridge;
import bridge.Produce;
import bridge.Truck;
import builder.Phone;
import builder.PhoneBuilder;
import composite.Composite;
import composite.Developer;
import composite.Manager;
import decorator.PannerPizza;
import decorator.Pizza;
import decorator.PlainPizza;
import decorator.TomatoPizza;
import facade.TravelPackage;
import factory.CalculateFactory;
import flyWeight.TextToCreate;
import proxy.Person;
import proxy.Proxy;
import singleton.Singleton;
import strategy.Strategy;
import template.ExcelFile;
import template.Template;
import template.TextFile;

public class DesignPattern {

	public static void main(String args[]) {

		System.out.println("Normal class ");
		Test1 test = new Test1();
		Test1 test1 = new Test1();
		System.out.println(test.toString() + " " + test1.toString());

		System.out.println();
		System.out.println("Singleton Example ");
		Singleton singleton = Singleton.getInstance();
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton.toString() + " " + singleton1.toString());

		System.out.println();
		System.out.println("Factory Pattern");
		CalculateFactory factory = new CalculateFactory("add");
		factory.calculate(10, 5);
		factory = new CalculateFactory("divide");
		factory.calculate(10, 5);

		System.out.println();
		System.out.println("Builder Pattern");
		// It is difficult to give all data when we create a object
		Phone phone = new Phone("Android", 3, "qualcomm", 5.5, 3000);
		System.out.println(phone.toString());
		// give one or two specification still can get the phone object
		phone = new PhoneBuilder().setOs("Android").setProcessor("Qualcomm").getPhone();
		System.out.println(phone.toString());

		System.out.println();
		System.out.println("Template Pattern");
		Template template = new ExcelFile();
		template.readProcessSave();
		template = new TextFile();
		template.readProcessSave();

		System.out.println();
		System.out.println("Adapter Pattern");
		Vehicle vehicle = new Bus();
		vehicle.startEngine();
		vehicle = new Car();
		vehicle.startEngine();
		// to treat walk as a Vehicle.. changed walk to vehicle class using adapter
		// class
		vehicle = new VehicleAdapter(new Walk());
		vehicle.startEngine();

		System.out.println();
		System.out.println("Facade Pattern");
		// inside of this class many interface called to book tour travel package
		TravelPackage travelPackage = new TravelPackage();
		travelPackage.book();

		System.out.println();
		System.out.println("Strategy Pattern");
		// will get different output because it will decides object in runtime
		Strategy route = new Strategy();
		route.getNavigate();
		route = new Strategy();
		route.getNavigate();
		route = new Strategy();
		route.getNavigate();

		System.out.println();
		System.out.println("Proxy Pattern");
		Person person = new Person("John", "Engineer");
		Proxy proxy = new Proxy(person);
		proxy.drive();
		person = new Person("Mani", "Pilot");
		proxy = new Proxy(person);
		proxy.drive();

		System.out.println();
		System.out.println("Bridge Pattern");
		Bridge vehicle1 = new Truck(new Produce(), new Assemble());
		vehicle1.manufacture();
		Bridge vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();

		System.out.println();
		System.out.println("Composite Pattern");
		Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer");
		Developer dev2 = new Developer(101, "Vinay Sharma", "Developer");
		Manager man1 = new Manager(200, "Kushagra Garg", "SEO Manager");
		Manager man2 = new Manager(201, "Vikram Sharma ", "Kushagra's Manager");
		// left
		Composite engDirectory = new Composite();
		engDirectory.addEmployee(dev1);
		engDirectory.addEmployee(dev2);
		// right
		Composite accDirectory = new Composite();
		accDirectory.addEmployee(man1);
		accDirectory.addEmployee(man2);
		// root
		Composite directory = new Composite();
		directory.addEmployee(engDirectory);
		directory.addEmployee(accDirectory);
		directory.showEmployeeDetails();

		System.out.println();
		System.out.println("Decorator Pattern");
		Pizza decorator = new TomatoPizza(new PannerPizza(new PlainPizza()));
		System.out.println("ingredents: " + decorator.getDescription());
		System.out.println("Cost: " + decorator.getCost());

		System.out.println();
		System.out.println("FlyWeight Pattern");
		String textToAdd = "Hi i'm a wordProcessor";
		TextToCreate text = new TextToCreate();
		text.create(textToAdd);
		System.out.println();
		text.createWithFlyWeight(textToAdd);
	}

}

class Test1 {

}