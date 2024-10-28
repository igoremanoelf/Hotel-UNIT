package me.workingclass.unit.reservation.modules.reservations.infra.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.workingclass.unit.reservation.modules.reservations.dtos.ReservationDTO;
import me.workingclass.unit.reservation.modules.reservations.services.CreateReservationService;
import me.workingclass.unit.reservation.modules.reservations.services.DeleteReservationService;
import me.workingclass.unit.reservation.modules.reservations.services.ListReservationService;
import me.workingclass.unit.reservation.modules.reservations.services.UpdateReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservas", description = "Operações relacionadas a reservas de hotel")
public class ReservationController {

  @Autowired
  private CreateReservationService createReservationService;

  @Autowired
  private ListReservationService listReservationService;

  @Autowired
  private UpdateReservationService updateReservationService;

  @Autowired
  private DeleteReservationService deleteReservationService;

  @Operation(summary = "Criar uma nova reserva", description = "Adiciona uma nova reserva ao sistema.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Reserva criada com sucesso."),
    @ApiResponse(responseCode = "400", description = "Dados inválidos.")
  })
  @PostMapping
  public ResponseEntity<ReservationDTO> createReservation(
    @Parameter(description = "Dados da reserva a serem criados") @RequestBody ReservationDTO reservationDTO) {
    ReservationDTO createdReservation = createReservationService.createReservation(reservationDTO);
    return ResponseEntity.ok(createdReservation);
  }

  @Operation(summary = "Listar todas as reservas", description = "Recupera uma lista de todas as reservas.")
  @ApiResponse(responseCode = "200", description = "Lista de reservas recuperada com sucesso.")
  @GetMapping
  public ResponseEntity<List<ReservationDTO>> getAllReservations() {
    List<ReservationDTO> reservations = listReservationService.getAllReservations();
    return ResponseEntity.ok(reservations);
  }

  @Operation(summary = "Listar reservas por e-mail", description = "Recupera uma lista de reservas baseadas no e-mail do usuário.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Lista de reservas recuperada com sucesso."),
    @ApiResponse(responseCode = "404", description = "Reservas não encontradas para o e-mail fornecido.")
  })
  @GetMapping("/{email}")
  public ResponseEntity<List<ReservationDTO>> getReservationsByEmail(
    @Parameter(description = "E-mail do usuário para filtrar as reservas") @PathVariable String email) {
    List<ReservationDTO> reservations = listReservationService.getReservationsByEmail(email);
    return ResponseEntity.ok(reservations);
  }

  @Operation(summary = "Atualizar uma reserva existente", description = "Atualiza os detalhes de uma reserva existente.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso."),
    @ApiResponse(responseCode = "404", description = "Reserva não encontrada.")
  })
  @PutMapping("/{id}")
  public ResponseEntity<ReservationDTO> updateReservation(
    @Parameter(description = "ID da reserva a ser atualizada") @PathVariable Long id,
    @Parameter(description = "Dados da reserva a serem atualizados") @RequestBody ReservationDTO reservationDTO) {
    ReservationDTO updatedReservation = updateReservationService.updateReservation(id, reservationDTO);
    return ResponseEntity.ok(updatedReservation);
  }

  @Operation(summary = "Excluir uma reserva", description = "Remove uma reserva do sistema.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Reserva excluída com sucesso."),
    @ApiResponse(responseCode = "404", description = "Reserva não encontrada.")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReservation(
    @Parameter(description = "ID da reserva a ser excluída") @PathVariable Long id) {
    deleteReservationService.deleteReservation(id);
    return ResponseEntity.noContent().build();
  }

}