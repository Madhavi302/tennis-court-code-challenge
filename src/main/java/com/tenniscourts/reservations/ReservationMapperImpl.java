package com.tenniscourts.reservations;

import org.springframework.stereotype.Service;

import com.tenniscourts.guests.Guest;
import com.tenniscourts.schedules.Schedule;

@Service
public class ReservationMapperImpl implements ReservationMapper{

	@Override
	public Reservation map(ReservationDTO source) {
		Reservation reservation= new Reservation();
		reservation.setId(source.getId());
		reservation.setReservationStatus(ReservationStatus.valueOf(source.getReservationStatus()));
		
		return reservation;
	}

	@Override
	public ReservationDTO map(Reservation source) {
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setGuestId(source.getGuest().getId());
		reservationDTO.setId(source.getId());
		reservationDTO.setScheduledId(source.getSchedule().getId());
		reservationDTO.setRefundValue(source.getRefundValue());
		reservationDTO.setReservationStatus(source.getReservationStatus().toString());
		
		return reservationDTO;
	}

	@Override
	public Reservation map(CreateReservationRequestDTO source) {
		Reservation reservation= new Reservation();
		Guest guest= new Guest();
		guest.setId(source.getGuestId());
		reservation.setGuest(guest);
		Schedule schedule = new Schedule();
		schedule.setId(source.getScheduleId());
		reservation.setSchedule(schedule);
		return reservation;
	}

}
