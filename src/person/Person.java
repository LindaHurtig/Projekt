package person;

public class Person {
	
	private String name;
	private int age;
	private int startNumber;

	public Person(int startNumber, String name, int age) {
		super();
		this.setStartNumber(startNumber);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
