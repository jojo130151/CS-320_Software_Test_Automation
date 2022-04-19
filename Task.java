/**
 * Task Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/27/22
 */

package Main;

public class Task {

	// Create variables to store the values associated with a Task object
	String taskID;
	String name;
	String description;
	
	/**
	 * Constructor for Task object. Checks that the parameter variables are valid and then sets them.
	 * 
	 * @param	taskId        Unique ID assigned to the task
	 * @param	name          The name assigned to the task
	 * @param   description   The description of the task
	 * 
	 * @return                A new instance of the Task object
	 */
	public Task (String taskID, String name, String description) {
		if (taskID == null || taskID.length() > 10 || taskID == "0") {
			throw new IllegalArgumentException("Invalid Task ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.taskID = taskID;
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Retrieves the ID for a Task object
	 *
	 * @return  Return the taskID variable for the Task object
	 */
	public String getTaskID() {
		return this.taskID;
	}
	
	/**
	 * Retrieves the name for a Task object
	 *
	 * @return  Return the name variable for the Task object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retrieves the description for a Task object
	 *
	 * @return  Return the description variable for the Task object
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Updates and changes the name for a Task object
	 *
	 * @return  the Task variable with the change of the new name
	 */
	public Task setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Updates and changes the description for a Task object
	 *
	 * @return  the Task variable with the change of the new description
	 */
	public Task setDescription(String description) {
		this.description = description;
		return this;
	}
}

