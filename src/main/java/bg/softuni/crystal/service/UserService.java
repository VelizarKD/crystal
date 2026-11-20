package bg.softuni.crystal.service;

import bg.softuni.crystal.domain.dtos.binding.UserRegisterFormDto;

public interface UserService {
    boolean register(UserRegisterFormDto registrationData);

}
