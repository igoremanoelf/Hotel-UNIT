package me.workingclass.unit.reservation.modules.reservations.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {

  private Long id;
  private String name;
  private String gender;
  private String email;
  private LocalDate arrivalDate;
  private int nights;
  private int guests;
  private String message;
  private LocalDateTime createdAt;

}
