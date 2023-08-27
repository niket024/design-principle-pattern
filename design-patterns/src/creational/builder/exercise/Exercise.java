package creational.builder.exercise;

class CodeBuilder {
	String className;
	String result;

	public CodeBuilder() {

	}

	public CodeBuilder(String className) {
		this.className = className;
		result = "public class " + className + "\n{\n";

	}

	public CodeBuilder addField(String name, String type) {
		result = result + " " + type + " " + name + ";\n";
		return this;
	}

	@Override
	public String toString() {
		result = result + "}";
		return result;
	}
}

public class Exercise {
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
}
