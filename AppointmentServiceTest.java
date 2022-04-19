package Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Main.Appointment;
import Main.AppointmentService;

class AppointmentServiceTest {
	
	AppointmentService appointmentServ = new AppointmentService();

	@Test
	@Tag("add")
	void addConstructedappointment() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		appointmentServ.addAppointment(new Appointment("12345678", date, "My description is in question."));
		assertTrue(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getAppointmentID().equals("12345678"));
		assertTrue(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getDate().equals(date));
		assertTrue(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getDescription().equals("My description is in question."));
	}
	
	@Test
	@Tag("add")
	void addNewAppointmentWithoutAppointment() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		appointmentServ.addAppointment(date, "Who am I but a description?");
		assertTrue(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getDate().equals(date));
		assertTrue(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getDescription().equals("Who am I but a description?"));
		assertNotNull(appointmentServ.appointments.get(appointmentServ.appointments.size() - 1).getAppointmentID());
	}
	
	@Test
	@Tag("delete")
	void deleteConstructedAppointment() {
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, +1);
		appointmentServ.addAppointment(new Appointment("12345", date, "I'm just a description in a sea of descriptions"));
		appointmentServ.deleteAppointment("12345");
		assertNull(appointmentServ.findAppointment("12345"));
	}
	
	@Test
	@Tag("delete")
	void deleteNullAppointment() {
		Assertions.assertThrows(NullPointerException.class, () -> {appointmentServ.deleteAppointment("911");
		});
	}
	
	@RepeatedTest(40)
	@Tag("add")
	void multipleIDs() {
		Calendar loopDate = Calendar.getInstance();
		loopDate.roll(Calendar.MONTH, +1);
		for (Integer i = 0; i < 100000; i++) {
			String ID = Integer.toString(i);
			appointmentServ.addAppointment(new Appointment(ID, loopDate, "Loops in loops in loops"));
		}
	appointmentServ.addAppointment(loopDate, "On no, it's another one");
	appointmentServ.addAppointment(loopDate, "On no, it's another one, again");
	appointmentServ.addAppointment(loopDate, "Well, this is awkward.");
	assertSame(appointmentServ.findAppointment("15"), appointmentServ.findAppointment("15")); // Tests the findContact method to 100%
	}
	
		
}
