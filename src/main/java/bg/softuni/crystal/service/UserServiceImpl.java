package bg.softuni.crystal.service;

import bg.softuni.crystal.domain.dtos.binding.UserRegisterFormDto;
import bg.softuni.crystal.domain.entities.UserEntity;
import bg.softuni.crystal.domain.entities.UserRoleEntity;
import bg.softuni.crystal.domain.enums.UserRoleEnum;
import bg.softuni.crystal.repositories.RoleRepository;
import bg.softuni.crystal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Locale;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public boolean register(UserRegisterFormDto registrationData) {
        String email = registrationData.getEmail()
                .trim()
                .toLowerCase(Locale.ROOT);

        if (userRepository.existByEmailIgnoreCase(email)) {
            return false;
        }

        UserRoleEntity userRole = roleRepository.findByRole(UserRoleEnum.USER)
                .orElseThrow(() ->
                        new IllegalStateException("USER role is missing"));

        UserEntity user = new UserEntity()
                .setEmail(email)
                .setPassword(passwordEncoder.encode(registrationData.getPassword()))
                .setFirstName(registrationData.getFirstName())
                .setLastName(registrationData.getLastName())
                .setActive(true)
                .setRoles(List.of(userRole));

        userRepository.save(user);
        return true;
    }
}
