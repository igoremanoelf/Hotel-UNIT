package me.workingclass.unit.reservation.modules.reservations.services;

import me.workingclass.unit.reservation.modules.reservations.dtos.ReservationDTO;
import me.workingclass.unit.reservation.modules.reservations.infra.jpa.entities.Reservation;
import me.workingclass.unit.reservation.modules.reservations.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateReservationService {

  @Autowired
  private IReservationRepository reservationRepository;

  public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
    Optional<Reservation> optionalReservation = reservationRepository.findById(id);

    if (optionalReservation.isPresent()) {
      Reservation reservation = optionalReservation.get();

      reservation.setName(reservationDTO.getName());
      reservation.setGender(reservationDTO.getGender());
      reservation.setEmail(reservationDTO.getEmail());
      reservation.setArrivalDate(reservationDTO.getArrivalDate());
      reservation.setNights(reservationDTO.getNights());
      reservation.setGuests(reservationDTO.getGuests());
      reservation.setMessage(reservationDTO.getMessage());

      Reservation updatedReservation = reservationRepository.save(reservation);

      return new ReservationDTO(
        updatedReservation.getId(),
        updatedReservation.getName(),
        updatedReservation.getGender(),
        updatedReservation.getEmail(),
        updatedReservation.getArrivalDate(),
        updatedReservation.getNights(),
        updatedReservation.getGuests(),
        updatedReservation.getMessage(),
        updatedReservation.getCreatedAt()
      );
    } else {
      throw new RuntimeException("Reservation not found");
    }
  }

}
