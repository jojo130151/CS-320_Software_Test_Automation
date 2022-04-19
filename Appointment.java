package Main;

import java.util.Calendar;

public class Appointment {

	String appointmentID;
	Calendar date;
	String description;
	
	/**
	 * The constructor for Appointment object. It checks that the parameter variables are valid and then sets them.
	 * 
	 * @param	AppointmentId    Unique ID assigned to the appointment
	 * @param	date             The date assigned to the appointment
	 * @param   description      The description of the appointment
	 * 
	 * @return                   A new instance of the Appointment object
	 */
	public Appointment(String appointmentID, Calendar date, String description) {
		if (appointmentID == null || appointmentID.length() > 10 || appointmentID == "0") {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		if (date == null || date.before(Calendar.getInstance())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.appointmentID = appointmentID;
		this.date = date;
		this.description = description;
	}
	

	/**
	 * Retrieves the ID for an Appointment object
	 *
	 * @return  Return the appointmentID variable for the Appointment object
	 */
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	/**
	 * Retrieves the Date for an Appointment object
	 *
	 * @return  Return the Date date variable for the Appointment object
	 */
	public Calendar getDate() {
		return this.date;
	}
	
	/**
	 * Retrieves the description for an Appointment object
	 *
	 * @return  Return the description variable for the Appointment object
	 */
	public String getDescription() {
		return this.description;
	}
}
