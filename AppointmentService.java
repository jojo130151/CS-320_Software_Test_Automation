package Main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AppointmentService {

	// Create ArrayLists to store created Appointments and Appointment IDs that are currently in use
	public ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	ArrayList<Integer> randomIDs = new ArrayList<Integer>();
	
	/**
	 * Add appointment to arrayList that has already been created with all fields established
	 *
	 * @param	Appointment object that already has an ID, date, and description
	 */
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		randomIDs.add(Integer.decode(appointment.getAppointmentID()));
	}
	
	/**
	 * Add a new Appointment with a generated unique ID and provided date and description.
	 *
	 * @param	date          The date of the appointment
	 * @param	description   The description of the appointment
	 */
	public void addAppointment(Calendar date, String description) {
		Random rand = new Random();
		int randomID = rand.nextInt(1000000000);
		
		while (randomID > 1000000000 || randomID < 0 || randomIDs.contains(randomID)) { // Grab a new ID if it is not valid
			randomID = rand.nextInt(1000000000);
		}
		
		randomIDs.add(randomID);
		String appointmentID = String.valueOf(randomID);
		
		appointments.add(new Appointment(appointmentID, date, description));
	}
	
	/**
	 * Delete an appointment, given the information of what appointment ID is associated with the appointment, from ArrayList and system
	 *
	 * @param	appointmentID  The appointment ID of a given Appointment object
	 */
	public void deleteAppointment(String appointmentID) {
		Appointment appointment = findAppointment(appointmentID);
		if (appointment == null) {                                        // If the attempt to find the Appointment fails, throw an exception
			throw new NullPointerException("Appointment ID is invalid, Does Not Exist");
		}
		randomIDs.remove(Integer.decode(appointment.getAppointmentID())); // Remove the ID from the randomIDs list so that it can be reused
		appointments.remove(appointment);                                 // Remove the Appointment from the appointments ArrayList
		
		if (findAppointment(appointmentID) != null) {
			throw new NullPointerException("Did Not Delete");
		}
	}
	
	/**
	 * Looks for the specific appointment with the appointmentID given in the parameter
	 *
	 * @param	appointmentID   The appointment ID for the appointment that the system is looking for
	 * @return                  The appointment that the system was looking for based on ID
	 * @return                  The value of null if list is empty or there is no matching value
	 */
	public Appointment findAppointment(String appointmentID) {
		if (appointments.isEmpty() == false);{
			for (int i = 0; i < appointments.size(); i++) {
				if (appointments.get(i).getAppointmentID() == appointmentID) {
					return appointments.get(i);
				}
			}
		}
		return null;
	}
}
