package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.Membership;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    List<Membership> findAllByUser_IdOrderByPurchasedAtDesc(Long userId);
}
