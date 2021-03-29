package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
