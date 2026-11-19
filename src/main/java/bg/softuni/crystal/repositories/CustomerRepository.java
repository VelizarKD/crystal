package bg.softuni.crystal.repositories;

import bg.softuni.crystal.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);
    List<Customer> findByNameContainingIgnoreCaseCase(String name);

}
