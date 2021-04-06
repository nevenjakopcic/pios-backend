package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.Equipment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query(value = "SELECT e.* FROM [pios].EQUIPMENT e\n" +
                    "WHERE (:userId IS NULL OR e.PERSON_ID = :userId)\n" +
                    "AND (:name IS NULL OR e.NAME LIKE %:name%)\n" +
                    "AND (:type IS NULL OR e.EQUIPMENT_TYPE_ID = :type)", nativeQuery = true)
    List<Equipment> getEquipment(@Param("userId") Long userId,
                                 @Param("name")   String name,
                                 @Param("type")   Long type);
}
