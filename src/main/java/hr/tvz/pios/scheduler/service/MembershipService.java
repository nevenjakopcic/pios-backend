package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.exception.NotFoundException;
import hr.tvz.pios.scheduler.model.Membership;
import hr.tvz.pios.scheduler.repository.MembershipRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final CurrentUserService currentUserService;

    public List<Membership> getAll() {
        return membershipRepository.findAll();
    }

    public Membership getById(Long id) {
        Membership membership = membershipRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Membership with ID %d not found.", id)));

        currentUserService.validateIsCurrentUserOrAdmin(membership.getUser().getId());

        return membership;
    }

    public List<Membership> getAllOfUser(Long userId) {
        currentUserService.validateIsCurrentUserOrAdmin(userId);
        List<Membership> memberships = membershipRepository.findAllByUser_Id(userId);

        if (memberships.isEmpty()) {
            throw new NotFoundException(String.format("No memberships found for user with ID %d.", userId));
        }

        return memberships;
    }
}
