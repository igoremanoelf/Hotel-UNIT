package me.workingclass.unit.reservation.modules.reservations.repositories;

import me.workingclass.unit.reservation.modules.reservations.dtos.ReservationDTO;
import me.workingclass.unit.reservation.modules.reservations.infra.jpa.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

  List<Reservation> findByEmail(String email);

}
