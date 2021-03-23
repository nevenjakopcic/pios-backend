package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.model.Membership;
import hr.tvz.pios.scheduler.service.MembershipService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membership")
@AllArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ApiResponse> getAllMemberships() {
        List<Membership> memberships = membershipService.getAll();

        return new ResponseEntity<>(new ApiResponse(memberships), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMembershipById(@PathVariable final Long id) {
        Membership membership = membershipService.getById(id);

        return new ResponseEntity<>(new ApiResponse(membership), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getAllMembershipsOfUser(@PathVariable final Long userId) {
        List<Membership> memberships = membershipService.getAllOfUser(userId);

        return new ResponseEntity<>(new ApiResponse(memberships), HttpStatus.OK);
    }
}
