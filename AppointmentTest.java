package Test;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Main.Appointment;

class AppointmentTest {
	
	@Test
	void testAppointment() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		Appointment appointment = new Appointment("12345", date, "It's a description.");
		assertTrue(appointment.getDate().equals(date));
		assertTrue(appointment.getDescription().equals("It's a description."));
	}
	
	@Test
	@Tag("ID")
	void appointmentIDTooLong() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678912345", date, "Just a plain Jane Doe doing her nails");
		});
	}
	
	@Test
	@Tag("ID")
	void appointmentIDIsNull() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "What's in a description?");
		});
	}
	
	@Test
	@Tag("Date")
	void dateIsInPast() {
		Calendar past = Calendar.getInstance();
		past.roll(Calendar.MONTH, -1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("456789", past, "What's in a description? Writings of the past");
		});
	}
	
	@Test
	@Tag("Date")
	void dateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567", null, "What's in a description? Nothing.");
		});
	}
	
	@Test
	@Tag("description")
	void appointmentDescriptionTooLong() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123450", date, "Destiny. Time. Death. Marriage. Birth. Funeral. We all have appointments. "
					+ "Some we look forward to but most we dread like they are hands reaching for us but we are afraid.");
		});
	}
	
	@Test
	@Tag("description")
	void appointmentDescriptionIsNull() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234512", date, null);
		});
	}

}
