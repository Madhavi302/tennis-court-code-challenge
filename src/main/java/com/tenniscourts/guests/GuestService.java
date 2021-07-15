package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenniscourts.exceptions.EntityNotFoundException;

@Service
public class GuestService {

	@Autowired
	GuestRepository guestRepository;

	public Guest createGuest(Guest guest) {
		return guestRepository.save(guest);
	}

	public Guest updateGuest(long id, Guest guest) {
		if (guestRepository.findById(id).isPresent()) {
			return guestRepository.save(guest);
		}

		throw new EntityNotFoundException("No Guest found with id " + id);
	}

	public Guest findGuestById(long id) {
		Optional<Guest> guest = guestRepository.findById(id);
		if (guest.isPresent()) {
			return guest.get();
		}

		throw new EntityNotFoundException("No Guest found with id " + id);
	}

	public Guest findGuestByName(String name) {
		Optional<Guest> guest = guestRepository.findByName(name);
		if (guest.isPresent()) {
			return guest.get();
		}

		throw new EntityNotFoundException("No Guest found with name " + name);
	}

	public List<Guest> findAllGuests() {
		return guestRepository.findAll();
	}

}
