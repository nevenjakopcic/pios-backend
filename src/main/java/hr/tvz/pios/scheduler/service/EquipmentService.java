package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.CreateEquipmentRequest;
import hr.tvz.pios.scheduler.dto.request.CreateEquipmentTypeRequest;
import hr.tvz.pios.scheduler.dto.response.EquipmentDto;
import hr.tvz.pios.scheduler.exception.DuplicateValueException;
import hr.tvz.pios.scheduler.exception.NoSuchTypeException;
import hr.tvz.pios.scheduler.exception.NotFoundException;
import hr.tvz.pios.scheduler.exception.UserAlreadyAssignedException;
import hr.tvz.pios.scheduler.mapper.EquipmentDtoMapper;
import hr.tvz.pios.scheduler.model.Equipment;
import hr.tvz.pios.scheduler.model.EquipmentType;
import hr.tvz.pios.scheduler.repository.EquipmentRepository;
import hr.tvz.pios.scheduler.repository.EquipmentTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository typeRepository;
    private final CurrentUserService currentUserService;

    public List<EquipmentDto> getEquipment(Boolean showOnlyUserEquipment, String name, Long type) {
        Long userId = null;
        if (Boolean.TRUE.equals(showOnlyUserEquipment)) {
            userId = currentUserService.getLoggedInUser().getId();
        }

        return equipmentRepository.getEquipment(userId, name, type).stream()
                                    .map(EquipmentDtoMapper::map)
                                    .collect(Collectors.toList());
    }

    public EquipmentDto createEquipment(CreateEquipmentRequest request) {
        Equipment equipment = Equipment.builder()
            .name(request.getName())
            .type(typeRepository.findById(request.getTypeId())
                .orElseThrow(() -> new NoSuchTypeException("Equipment type with id " + request.getTypeId() + " not found.")))
            .build();

        try {
            equipment = equipmentRepository.save(equipment);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateValueException("Equipment with the name '" + request.getName() + "' already exists.", e);
        }

        return EquipmentDtoMapper.map(equipment);
    }

    public void assignToCurrentUser(Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                                .orElseThrow(() -> new NotFoundException("Equipment with id " + equipmentId + " not found."));

        if (equipment.getUser() != null) {
            throw new UserAlreadyAssignedException("This equipment is already assigned to a user.");
        }

        equipment.setUser(currentUserService.getLoggedInUser());

        equipmentRepository.save(equipment);
    }

    public void unassignFromUser(Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
            .orElseThrow(() -> new NotFoundException("Equipment with id " + equipmentId + " not found."));

        if (equipment.getUser() != null) {
            currentUserService.validateIsLoggedInUserOrAdmin(equipment.getUser().getId(),
                "Not allowed to unassign other user from equipment.");
        }

        equipment.setUser(null);
        equipmentRepository.save(equipment);
    }

    public List<EquipmentType> getAllTypes() {
        return typeRepository.findAll();
    }

    public EquipmentType createType(CreateEquipmentTypeRequest request) {
        EquipmentType type = EquipmentType.builder()
            .name(request.getName()).build();

        return typeRepository.save(type);
    }
}
