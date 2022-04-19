/**
 * Task Service Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/27/22
 */

package Main;

import java.util.ArrayList;
import java.util.Random;

public class TaskService {

	// Create ArrayLists to store created Tasks and Task IDs that are currently in use
	public ArrayList<Task> tasks = new ArrayList<Task>();
	ArrayList<Integer> randomIDs = new ArrayList<Integer>();
	
	/**
	 * Add task to arrayList that has already been created with all fields established
	 *
	 * @param	Task object that already has an ID, name, and description
	 */
	public void addTask(Task task) {
		tasks.add(task);
		randomIDs.add(Integer.decode(task.getTaskID()));
	}
	
	/**
	 * Add a new Task with a generated unique ID and provided name and description.
	 *
	 * @param	name          The name of the task
	 * @param	description   The description of the task
	 */
	public void addTask(String name, String description) {
		Random rand = new Random();
		int randomID = rand.nextInt(1000000000);
		
		while (randomID > 1000000000 || randomID < 0 || randomIDs.contains(randomID)) {
			randomID = rand.nextInt(1000000000);
		}
		
		randomIDs.add(randomID);
		String taskID = String.valueOf(randomID);
		
		tasks.add(new Task(taskID, name, description));
	}
	
	/**
	 * Delete a task, given the information of what task ID is associated with the task, from ArrayList and system
	 *
	 * @param	taskID  The task ID of a given Task object
	 */
	public void deleteTask(String taskID) {
		Task task = findTask(taskID);
		if (task == null) { // If the attempt to find the Task fails, throw an exception
			throw new NullPointerException("Task ID is invalid, Does Not Exist");
		}
		randomIDs.remove(Integer.decode(task.getTaskID())); // Remove the ID from the randomIDs list so that it can be reused
		tasks.remove(task);                                 // Remove the Task from the tasks ArrayList
		
		if (findTask(taskID) != null) {
			throw new NullPointerException("Did Not Delete");
		}
	}
	
	/**
	 * Update and change the name of a given task, which is found by given task ID
	 *
	 * @param	taskID   The task ID for task that needs the name changed
	 * @param	name     The new desired name of the task
	 */
	public void updateName(String taskID, String name) {
		Task task = findTask(taskID);
		tasks.set(tasks.indexOf(task), task.setName(name));
	}
	
	/**
	 * Update and change the description of a given task, which is found by given taskID
	 *
	 * @param	taskID        The task ID for the task that needs description changed
	 * @param	description   The new desired description of the task
	 */
	public void updateDescription(String taskID, String description) {
		Task task = findTask(taskID);
		tasks.set(tasks.indexOf(task), task.setDescription(description));
	}
	
	/**
	 * Looks for the specific task with the taskID given in the parameter
	 *
	 * @param	taskID   The task ID for the task that the system is looking for
	 * @return           The task that the system was looking for based on ID
	 * @return           The value of null if list is empty or there is no matching value
	 */
	public Task findTask(String taskID) {
		if (tasks.isEmpty() == false);{
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).getTaskID() == taskID) {
					return tasks.get(i);
				}
			}
		}
		return null;
	}
}
