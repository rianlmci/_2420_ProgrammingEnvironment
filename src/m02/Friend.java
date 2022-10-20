package m02;
import java.util.Comparator;

/**
 * Represents a friend of a given name and age.
 * Friends can be compared by either their name or
 * by their age.
 * @author CSIS Starter Code + Rianna McIntyre
 */
public class Friend implements Comparable<Friend> {
	private String name;
	private int age;

	/**
	 * Compares friends by their ages
	 */
	public static final Comparator<Friend> BY_AGE = new ComparatorByAge();

	private static class ComparatorByAge implements Comparator<Friend> {

		@Override
		public int compare(Friend oneFriend, Friend anotherFriend) {
			return Integer.compare(oneFriend.age,anotherFriend.age);
		}
	}

	/**
	 *
	 * @param name name of friend
	 * @param age of friend
	 */
	public Friend(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Friend other) {
		return this.name.compareTo(other.name);
	}
	
}
