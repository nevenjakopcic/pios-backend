package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);
}