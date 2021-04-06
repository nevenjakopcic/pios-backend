package hr.tvz.pios.scheduler.mapper;

import hr.tvz.pios.scheduler.dto.response.EquipmentDto;
import hr.tvz.pios.scheduler.model.Equipment;

public class EquipmentDtoMapper {

    public static EquipmentDto map(Equipment source) {
        return EquipmentDto.builder()
            .id(source.getId())
            .name(source.getName())
            .type(source.getType())
            .user(source.getUser() == null ? null : UserDtoMapper.map(source.getUser())).build();
    }

    private EquipmentDtoMapper() {}
}
