package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.response.ReservationDto;
import hr.tvz.pios.scheduler.mapper.ReservationDtoMapper;
import hr.tvz.pios.scheduler.repository.ReservationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                                                .map(ReservationDtoMapper::map)
                                                .collect(Collectors.toList());
    }
}
