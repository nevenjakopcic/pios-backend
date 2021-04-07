package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.CreateEquipmentRequest;
import hr.tvz.pios.scheduler.dto.request.CreateEquipmentTypeRequest;
import hr.tvz.pios.scheduler.service.EquipmentService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<ApiResponse> getEquipment(@RequestParam(required = false) final Boolean showOnlyUserEquipment,
                                                    @RequestParam(required = false) final String name,
                                                    @RequestParam(required = false) final Long type) {
        return new ResponseEntity<>(new ApiResponse(equipmentService.getEquipment(showOnlyUserEquipment, name, type)), HttpStatus.OK);
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ApiResponse> createEquipment(@Valid @RequestBody final CreateEquipmentRequest request) {
        return new ResponseEntity<>(new ApiResponse(equipmentService.createEquipment(request)), HttpStatus.CREATED);
    }

    @PostMapping("/assign/{equipmentId}")
    public ResponseEntity<ApiResponse> assignToCurrentUser(@PathVariable final Long equipmentId) {
        equipmentService.assignToCurrentUser(equipmentId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/unassign/{equipmentId}")
    public ResponseEntity<ApiResponse> unassignFromUser(@PathVariable final Long equipmentId) {
        equipmentService.unassignFromUser(equipmentId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/type")
    public ResponseEntity<ApiResponse> getAllTypes() {
        return new ResponseEntity<>(new ApiResponse(equipmentService.getAllTypes()), HttpStatus.OK);
    }

    @PostMapping("/type")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ApiResponse> createEquipmentType(@Valid @RequestBody final CreateEquipmentTypeRequest request) {
        return new ResponseEntity<>(new ApiResponse(equipmentService.createType(request)), HttpStatus.CREATED);
    }
}
