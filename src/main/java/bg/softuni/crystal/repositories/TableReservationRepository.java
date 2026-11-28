package bg.softuni.crystal.repositories;

import bg.softuni.crystal.domain.entities.TableEntity;
import bg.softuni.crystal.domain.entities.TableReservation;
import bg.softuni.crystal.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.time.LocalTime;

public interface TableReservationRepository extends JpaRepository<TableReservation, Long> {
    List<TableReservation> findByReservationDate(LocalDate reservationDate);

    List<TableReservation> findByTable(TableEntity table);

    List<TableReservation> findByUser(UserEntity user);

    boolean existsByTableAndReservationDate(TableEntity table, LocalDate reservationDate, LocalTime reservationTime);
}
