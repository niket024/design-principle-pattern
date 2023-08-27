package creational.builder.fluent.inheritance;

//builder inheritance with recursive generics

//Note: uncomment the PersonBuilder1 and EmployeeBuilder1 to demonstrate the actual problem
class Person {
	public String name;

	public String position;

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", position='" + position + '\'' + '}';
	}
}

//class PersonBuilder1 {
//	protected Person person = new Person();
//
//	public PersonBuilder1 withName(String name) {
//		person.name = name;
//		return this;
//	}
//
//	public Person build() {
//		return person;
//	}
//}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
	protected Person person = new Person();

// critical to return SELF here
	public SELF withName(String name) {
		person.name = name;
		return self();
	}

	protected SELF self() {
		// unchecked cast, but actually safe
		// proof: try sticking a non-PersonBuilder
		// as SELF parameter; it won't work!
		return (SELF) this;
	}

	public Person build() {
		return person;
	}
}

//class EmployeeBuilder1 extends PersonBuilder1 {
//	public EmployeeBuilder1 worksAs(String position) {
//		person.position = position;
//		return this;
//	}
//
//}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	public EmployeeBuilder worksAs(String position) {
		person.position = position;
		return self();
	}

	@Override
	protected EmployeeBuilder self() {
		return this;
	}
}

class Demo {
	public static void main(String[] args) {
		
//		EmployeeBuilder1 builder1 = new EmployeeBuilder1().
//				withName("abc").
//				worksAs("Quantitative Analyst").
//				build();

		EmployeeBuilder eb = new EmployeeBuilder().
				withName("Niket").
				worksAs("Senior Architect");
		System.out.println(eb.build());
	}
}