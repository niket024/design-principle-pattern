package creational.factory.execersise;

class Person {
	public int id;
	public String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class PersonFactory {
	private static int id = 0;

	public Person createPerson(String name) {
		Person person = new Person(id, name);
		id++;
		return person;
	}
}

public class ExerciseDemo {
	public static void main(String[] args) {
		PersonFactory personFactory = new PersonFactory();
		Person person = personFactory.createPerson("abc");
		System.out.println(person.id);
		Person person1 = personFactory.createPerson("xyz");
		System.out.println(person1.id);
	}
}