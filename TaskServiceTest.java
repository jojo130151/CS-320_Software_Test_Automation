/**
 * TaskServiceTest Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/27/22
 */

package Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Main.Task;
import Main.TaskService;

class TaskServiceTest {

	// Creates an instance of the TaskService class to utilize methods and ArrayLists for testing.
	TaskService taskServ = new TaskService();
	
	@Test
	@Tag("add")
	void addConstructedTask() {
		taskServ.addTask(new Task("12345678", "Emily Dickinson", "In love with Sue and its cute"));
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getTaskID().equals("12345678"));
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getName().equals("Emily Dickinson"));
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getDescription().equals("In love with Sue and its cute"));
	}
	
	@Test
	@Tag("add")
	void addTaskWithoutID() {
		taskServ.addTask("Catra", "A cat who has a redemption arc and loves Adora");
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getName().equals("Catra"));
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getDescription().equals("A cat who has a redemption arc and loves Adora"));
		assertNotNull(taskServ.tasks.get(taskServ.tasks.size() - 1).getTaskID());
	}
	
	@Test
	@Tag("delete")
	void deleteConstructedTask() {
		taskServ.addTask(new Task("12345", "Katniss Everdeen", "A whiz with a bow"));
		taskServ.deleteTask("12345");
		assertNull(taskServ.findTask("12345"));
	}
	
	@Test
	@Tag("delete")
	void deleteNullTask() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			taskServ.deleteTask("911");
		});
	}
	
	@Test
	@Tag("update")
	void updateNameTest() {
		taskServ.addTask(new Task("56765", "Maribel Madrigal", "Underappreciated by her family"));
		taskServ.updateName("56765", "Luisa Madrigal");
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getName().equals("Luisa Madrigal"));
	}
	
	@Test
	@Tag("update")
	void updateDescriptionTest() {
		taskServ.addTask(new Task("56777", "Isabella Swan", "Young and stupid and in love"));
		taskServ.updateDescription("56777", "A vampire with a large family and a child");
		assertTrue(taskServ.tasks.get(taskServ.tasks.size() - 1).getDescription().equals("A vampire with a large family and a child"));
	}
	
	@RepeatedTest(40)
	@Tag("add")
	void multipleIDs() {
		for (Integer i = 0; i < 100000; i++) {
			String ID = Integer.toString(i);
			taskServ.addTask(new Task(ID, "Judas Iscariot", "Traitor"));
		}
	taskServ.addTask("Woody", "A toy with a lot of heart.");
	assertSame(taskServ.findTask("15"), taskServ.findTask("15")); // Tests the findTask method to 100%
	}

}
