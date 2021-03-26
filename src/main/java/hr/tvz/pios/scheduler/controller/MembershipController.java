package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.CreateMembershipRequest;
import hr.tvz.pios.scheduler.service.MembershipService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membership")
@AllArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ApiResponse> getAllMemberships() {
        return new ResponseEntity<>(new ApiResponse(membershipService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMembershipById(@PathVariable final Long id) {
        return new ResponseEntity<>(new ApiResponse(membershipService.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getAllMembershipsOfUser(@PathVariable final Long userId) {
        return new ResponseEntity<>(new ApiResponse(membershipService.getAllOfUser(userId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createMembership(@Valid @RequestBody final CreateMembershipRequest request) {
        return new ResponseEntity<>(new ApiResponse(membershipService.createMembership(request)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMembershipById(@PathVariable Long id) {
        membershipService.deleteMembership(id);

        return ResponseEntity.noContent().build();
    }
}
