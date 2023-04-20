package bg.softuni.crystal.repositories;

import bg.softuni.crystal.domain.entities.UserRoleEntity;
import bg.softuni.crystal.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRoleEntity, String> {

    Optional<UserRoleEntity> findByRole(UserRoleEnum role);
}
