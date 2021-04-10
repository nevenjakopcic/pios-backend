package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.CreateReservationRequest;
import hr.tvz.pios.scheduler.dto.response.ReservationDto;
import hr.tvz.pios.scheduler.mapper.ReservationDtoMapper;
import hr.tvz.pios.scheduler.model.Reservation;
import hr.tvz.pios.scheduler.repository.ReservationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CurrentUserService currentUserService;

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                                                .map(ReservationDtoMapper::map)
                                                .collect(Collectors.toList());
    }

    public ReservationDto createReservation(CreateReservationRequest request) {
        Reservation reservation = Reservation.builder()
            .from(request.getFrom())
            .to(request.getTo())
            .description(request.getDescription())
            .user(currentUserService.getLoggedInUser()).build();

        return ReservationDtoMapper.map(reservationRepository.save(reservation));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
