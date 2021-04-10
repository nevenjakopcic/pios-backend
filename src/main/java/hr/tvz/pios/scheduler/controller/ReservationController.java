package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.CreateReservationRequest;
import hr.tvz.pios.scheduler.service.ReservationService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllReservations() {
        return new ResponseEntity<>(new ApiResponse(reservationService.getAllReservations()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createReservation(@Valid @RequestBody final CreateReservationRequest request) {
        return new ResponseEntity<>(new ApiResponse(reservationService.createReservation(request)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteReservation(@PathVariable final Long id) {
        reservationService.deleteReservation(id);

        return ResponseEntity.noContent().build();
    }
}
