package me.workingclass.unit.reservation.modules.reservations.infra.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "gender", nullable = false, length = 10)
  private String gender;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "arrival_date", nullable = false)
  private LocalDate arrivalDate;

  @Column(name = "nights", nullable = false)
  private int nights;

  @Column(name = "guests", nullable = false)
  private int guests;

  @Column(name = "message")
  private String message;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }

}
