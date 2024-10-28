package me.workingclass.unit.reservation.modules.reservations.services;

import me.workingclass.unit.reservation.modules.reservations.dtos.ReservationDTO;
import me.workingclass.unit.reservation.modules.reservations.infra.jpa.entities.Reservation;
import me.workingclass.unit.reservation.modules.reservations.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateReservationService {

  @Autowired
  private IReservationRepository reservationRepository;

  public ReservationDTO createReservation(ReservationDTO reservationDTO) {
    Reservation reservation = new Reservation();

    reservation.setName(reservationDTO.getName());
    reservation.setGender(reservationDTO.getGender());
    reservation.setEmail(reservationDTO.getEmail());
    reservation.setArrivalDate(reservationDTO.getArrivalDate());
    reservation.setNights(reservationDTO.getNights());
    reservation.setGuests(reservationDTO.getGuests());
    reservation.setMessage(reservationDTO.getMessage());

    Reservation savedReservation = reservationRepository.save(reservation);

    return new ReservationDTO(
      savedReservation.getId(),
      savedReservation.getName(),
      savedReservation.getGender(),
      savedReservation.getEmail(),
      savedReservation.getArrivalDate(),
      savedReservation.getNights(),
      savedReservation.getGuests(),
      savedReservation.getMessage(),
      savedReservation.getCreatedAt()
    );
  }
}
