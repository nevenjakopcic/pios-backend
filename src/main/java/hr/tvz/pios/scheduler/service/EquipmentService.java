package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.CreateEquipmentTypeRequest;
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
}
