package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.CreateEquipmentTypeRequest;
import hr.tvz.pios.scheduler.service.EquipmentService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

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
