package me.workingclass.unit.reservation.modules.reservations.services;

import me.workingclass.unit.reservation.modules.reservations.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteReservationService {

  @Autowired
  private IReservationRepository reservationRepository;

  public void deleteReservation(Long id) {
    if (reservationRepository.existsById(id)) {
      reservationRepository.deleteById(id);
    } else {
      throw new RuntimeException("Reservation not found");
    }
  }
}
