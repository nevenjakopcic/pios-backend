package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.CreateEquipmentRequest;
import hr.tvz.pios.scheduler.dto.request.CreateEquipmentTypeRequest;
import hr.tvz.pios.scheduler.dto.response.EquipmentDto;
import hr.tvz.pios.scheduler.exception.NoSuchTypeException;
import hr.tvz.pios.scheduler.mapper.EquipmentDtoMapper;
import hr.tvz.pios.scheduler.model.Equipment;
import hr.tvz.pios.scheduler.model.EquipmentType;
import hr.tvz.pios.scheduler.repository.EquipmentRepository;
import hr.tvz.pios.scheduler.repository.EquipmentTypeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository typeRepository;

    public List<EquipmentType> getAllTypes() {
        return typeRepository.findAll();
    }

    public EquipmentType createType(CreateEquipmentTypeRequest request) {
        EquipmentType type = EquipmentType.builder()
            .name(request.getName()).build();

        return typeRepository.save(type);
    }

    public EquipmentDto createEquipment(CreateEquipmentRequest request) {
        Equipment equipment = Equipment.builder()
            .name(request.getName())
            .type(typeRepository.findById(request.getTypeId())
                    .orElseThrow(() -> new NoSuchTypeException("Equipment type with id " + request.getTypeId() + " not found.")))
            .build();

        equipment = equipmentRepository.save(equipment);

        return EquipmentDtoMapper.map(equipment);
    }
}
