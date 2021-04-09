package hr.tvz.pios.scheduler.repository;

import hr.tvz.pios.scheduler.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
