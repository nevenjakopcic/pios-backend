package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {

}
