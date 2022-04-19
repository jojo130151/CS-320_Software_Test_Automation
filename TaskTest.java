/**
 * TaskTest Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/27/22
 */

package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Main.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("123", "Edward Cullen", "An old vampire who is very broody. We do not stan.");
		assertTrue(task.getName().equals("Edward Cullen"));
		assertTrue(task.getDescription().equals("An old vampire who is very broody. We do not stan."));
	}
	
	@Test
	@Tag("ID")
	void taskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678912", "John", "Just a plain Jane Doe");
		});
	}
	
	@Test
	@Tag("ID")
	void taskIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Alice Cullen", "Can see the future, doesn't like dogs");
		});
	}
	
	@Test
	@Tag("name")
	void taskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456", "MrHowDoYouDoTodayOnThisFineDay", "He does not do well.");
		});
	}
	
	@Test
	@Tag("name")
	void taskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Who am I? Who am I? How dare you!");
		});
	}
	
	@Test
	@Tag("description")
	void taskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123450", "Harry Potter", "Was born as the seventh month dies. You're a wizard Harry. But, "
					+ "also the chosen one. You will just have to fight for your life for the next six years at "
					+ "a very so called safe school.");
		});
	}
	
	@Test
	@Tag("description")
	void taskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512", "Hermione Granger", null);
		});
	}

}
