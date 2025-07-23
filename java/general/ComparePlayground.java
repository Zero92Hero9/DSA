import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Comparator;

class Person {
	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	} 

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
}

class PersonComparator implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}



public class ComparePlayground {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person(20, "Akki");
		Person p2 = new Person(15, "Mokshi");
		Person p3 = new Person(46, "Priya");
		Person p4 = new Person(49, "Raghu");

		persons.addAll(List.of(p1, p2, p3, p4));
		Collections.sort(persons, Comparator.comparingInt(Person::getAge).reversed());

		persons.stream().forEach(p -> System.out.print(p.getName()));
	}
}

