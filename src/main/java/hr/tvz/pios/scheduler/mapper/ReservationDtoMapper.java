package hr.tvz.pios.scheduler.mapper;

import hr.tvz.pios.scheduler.dto.response.ReservationDto;
import hr.tvz.pios.scheduler.model.Reservation;

public class ReservationDtoMapper {

    public static ReservationDto map(Reservation source) {
        return ReservationDto.builder()
            .id(source.getId())
            .from(source.getFrom())
            .to(source.getTo())
            .description(source.getDescription())
            .user(UserDtoMapper.map(source.getUser())).build();
    }

    private ReservationDtoMapper() {}
}
