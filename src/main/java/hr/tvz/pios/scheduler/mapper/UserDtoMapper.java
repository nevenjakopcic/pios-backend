package hr.tvz.pios.scheduler.mapper;

import hr.tvz.pios.scheduler.dto.response.UserDto;
import hr.tvz.pios.scheduler.model.User;

public class UserDtoMapper {

    public static UserDto map(User source) {
        return UserDto.builder()
            .id(source.getId())
            .username(source.getUsername())
            .email(source.getEmail())
            .role(source.getRole().ordinal()).build();
    }

    private UserDtoMapper() {}
}
