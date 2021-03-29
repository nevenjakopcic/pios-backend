package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.CreateMembershipRequest;
import hr.tvz.pios.scheduler.dto.response.MembershipDto;
import hr.tvz.pios.scheduler.exception.NotFoundException;
import hr.tvz.pios.scheduler.mapper.MembershipToDtoMapper;
import hr.tvz.pios.scheduler.model.Membership;
import hr.tvz.pios.scheduler.repository.MembershipRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final CurrentUserService currentUserService;

    public List<MembershipDto> getAll() {
        List<Membership> memberships = membershipRepository.findAll(Sort.by(Direction.DESC, "purchasedAt"));

        return memberships.stream()
                            .map(MembershipToDtoMapper::map)
                            .collect(Collectors.toList());
    }

    public MembershipDto getById(Long id) {
        Membership membership = membershipRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Membership with ID %d not found.", id)));

        currentUserService.validateIsCurrentUserOrAdmin(membership.getUser().getId());

        return MembershipToDtoMapper.map(membership);
    }

    public List<MembershipDto> getAllOfUser(Long userId) {
        currentUserService.validateIsCurrentUserOrAdmin(userId);
        List<Membership> memberships = membershipRepository.findAllByUser_IdOrderByPurchasedAtDesc(userId);

        if (memberships.isEmpty()) {
            throw new NotFoundException(String.format("No memberships found for user with ID %d.", userId));
        }

        return memberships.stream()
                            .map(MembershipToDtoMapper::map)
                            .collect(Collectors.toList());
    }

    public MembershipDto createMembership(CreateMembershipRequest request) {
        Membership membership = Membership.builder()
            .purchasedAt(request.getPurchasedAt())
            .amount(request.getAmount())
            .purchaseType(request.getPurchaseType())
            .user(currentUserService.getLoggedInUser())
            .duration(request.getDuration()).build();

        membership = membershipRepository.save(membership);

        return MembershipToDtoMapper.map(membership);
    }

    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}
