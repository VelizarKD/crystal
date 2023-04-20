package bg.softuni.crystal.repositories;

import bg.softuni.crystal.domain.entities.Customer;
import bg.softuni.crystal.domain.entities.TableEntity;
import bg.softuni.crystal.domain.entities.TableReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TableReservationRepository extends JpaRepository<TableReservation, Long> {
    List<TableReservation> findByReservationDate(LocalDate reservationDate);

    List<TableReservation> findByTable(TableEntity table);

    List<TableReservation> findByCustomer(Customer customer);

    boolean existsByTableAndReservationDate(TableEntity table, LocalDate reservationDate);
}
