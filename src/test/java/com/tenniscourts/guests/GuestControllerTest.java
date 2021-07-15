package com.tenniscourts.guests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.tenniscourts.exceptions.EntityNotFoundException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = GuestController.class)
public class GuestControllerTest {

	@InjectMocks
	GuestController controller;

	@Mock
	GuestService guestService;

	@Test
	public void testCreateGuest() throws Exception {		
		Guest guest=new Guest();
		guest.setName("test");
		ResponseEntity<Guest> entity = controller.createGuest(guest);
		guest.setId(Long.valueOf(123));
		when(guestService.createGuest(guest)).thenReturn(guest);
		assertEquals(201, entity.getStatusCodeValue());
	}
	
	@Test
	public void testUpdateGuestPositive() throws Exception {
		Guest guest=new Guest();
		guest.setId(Long.valueOf(123));
		guest.setName("test1");
		ResponseEntity<Guest> entity = controller.updateGuestById(123, guest);		
		when(guestService.updateGuest(123,guest)).thenReturn(guest);
		assertEquals(201, entity.getStatusCodeValue());
	}

	@Test
	public void testUpdateGuestNegative() throws Exception {
		Guest guest=new Guest();
		guest.setId(Long.valueOf(123));
		guest.setName("test1");
		ResponseEntity<Guest> entity = controller.updateGuestById(123, guest);		
		when(guestService.updateGuest(123,guest)).thenThrow(new EntityNotFoundException("No guest found with id"));
		assertEquals(404, entity.getStatusCodeValue());
	}
	
	@Test
	public void testFindGuestByIdPositive_And_Negative() throws Exception {
		Guest guest=new Guest();
		guest.setId(Long.valueOf(123));
		guest.setName("test1");
		when(guestService.updateGuest(123,guest)).thenReturn(guest).thenThrow(new EntityNotFoundException("No guest found with id"));
		ResponseEntity<Guest> entity = controller.findGuestById(Long.valueOf(123));	
		assertEquals(200, entity.getStatusCodeValue());
		entity = controller.findGuestById(Long.valueOf(123));	
		assertEquals(404, entity.getStatusCodeValue());
	}
	
	@Test
	public void testFindGuestByNamePositive_And_Negative() throws Exception {
		Guest guest=new Guest();
		guest.setId(Long.valueOf(123));
		guest.setName("test1");
		when(guestService.updateGuest(123,guest)).thenReturn(guest).thenThrow(new EntityNotFoundException("No guest found with name"));
		ResponseEntity<Guest> entity = controller.findGuestByName("test1");	
		assertEquals(200, entity.getStatusCodeValue());
		entity = controller.findGuestByName("test3");	
		assertEquals(404, entity.getStatusCodeValue());
	}
	
	

	
}
