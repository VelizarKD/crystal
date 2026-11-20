package bg.softuni.crystal.config;

import bg.softuni.crystal.domain.entities.UserRoleEntity;
import bg.softuni.crystal.domain.enums.UserRoleEnum;
import bg.softuni.crystal.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleDataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void run(String... args) {
        for (UserRoleEnum role : UserRoleEnum.values()) {
            roleRepository.findByRole(role)
                    .orElseGet(() -> roleRepository.save(
                            new UserRoleEntity().setRole(role)
                    ));
        }
    }

}
