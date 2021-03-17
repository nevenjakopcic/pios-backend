package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<UserPreferences, Long> {

}
