package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);
}
