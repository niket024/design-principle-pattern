package creational.abstractfactory;

import java.util.HashMap;
import java.util.Map;

interface IHotDrink {
	void consume();
}

class Tea implements IHotDrink {
	@Override
	public void consume() {
		System.out.println("This tea is nice but I'd prefer it with milk.");
	}
}

class Coffee implements IHotDrink {
	@Override
	public void consume() {
		System.out.println("This coffee is delicious");
	}
}

interface IHotDrinkFactory {
	IHotDrink prepare(int amount);
}

class TeaFactory implements IHotDrinkFactory {
	@Override
	public IHotDrink prepare(int amount) {
		System.out.println("Put in tea bag, boil water, pour " + amount + "ml, add lemon, enjoy!");
		return new Tea();
	}
}

class CoffeeFactory implements IHotDrinkFactory {

	@Override
	public IHotDrink prepare(int amount) {
		System.out.println("Grind some beans, boil water, pour " + amount + " ml, add cream and sugar, enjoy!");
		return new Coffee();
	}
}

class HotDrinkMachine {
	public enum AvailableDrink {
		COFFEE, TEA
	}

	private Map<String, IHotDrinkFactory> factories = new HashMap<>();

	public HotDrinkMachine() throws Exception {

		factories.put("tea", new TeaFactory());
		factories.put("coffee", new CoffeeFactory());

	}

	public IHotDrink makeDrink(String drink, int amount) {
		return (factories.get(drink)).prepare(amount);
	}
}

class AbstractFactoryDemo {

	public static IHotDrink getHotDrink(String drinkType, int drinkAmount) throws Exception {
		HotDrinkMachine machine = new HotDrinkMachine();
		IHotDrink hotDrink = machine.makeDrink(drinkType, drinkAmount);
		return hotDrink;
	}

	public static void main(String[] args) throws Exception {
		IHotDrink hotDrink = getHotDrink("tea", 200);
		hotDrink.consume();
		System.out.println("Enjoy!!");
		hotDrink = getHotDrink("coffee", 300);
		hotDrink.consume();
		System.out.println("Enjoy!!");


	}
}
