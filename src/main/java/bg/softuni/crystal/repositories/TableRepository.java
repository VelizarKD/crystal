package bg.softuni.crystal.repositories;

import bg.softuni.crystal.domain.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Long> {
    List<TableEntity> findByCapacityGreaterThanEqual(int capacity);
}
