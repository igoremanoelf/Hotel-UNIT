package me.workingclass.unit.reservation.modules.reservations.services;

import me.workingclass.unit.reservation.modules.reservations.dtos.ReservationDTO;
import me.workingclass.unit.reservation.modules.reservations.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListReservationService {

  @Autowired
  private IReservationRepository reservationRepository;

  public List<ReservationDTO> getReservationsByEmail(String email) {
    return reservationRepository.findByEmail(email).stream()
      .map(reservation -> new ReservationDTO(
        reservation.getId(),
        reservation.getName(),
        reservation.getGender(),
        reservation.getEmail(),
        reservation.getArrivalDate(),
        reservation.getNights(),
        reservation.getGuests(),
        reservation.getMessage(),
        reservation.getCreatedAt()
      ))
      .collect(Collectors.toList());
  }

  public List<ReservationDTO> getAllReservations() {
    return reservationRepository.findAll()
      .stream()
      .map(reservation -> new ReservationDTO(
        reservation.getId(),
        reservation.getName(),
        reservation.getGender(),
        reservation.getEmail(),
        reservation.getArrivalDate(),
        reservation.getNights(),
        reservation.getGuests(),
        reservation.getMessage(),
        reservation.getCreatedAt()
      ))
      .collect(Collectors.toList());
  }

}
