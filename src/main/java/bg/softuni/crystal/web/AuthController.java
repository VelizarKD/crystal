package bg.softuni.crystal.web;

import bg.softuni.crystal.domain.dtos.binding.UserRegisterFormDto;
import bg.softuni.crystal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationData", new UserRegisterFormDto());
        return "register";
    }
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("registrationData")
            UserRegisterFormDto registrationData,
            BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "register";
            }
            if (!userService.register(registrationData)) {
                bindingResult.rejectValue(
                        "email",
                        "email.exists",
                        "An account with this email already exists."
                );
                return "register";
            }

            return "redirect:/login?registered";
    }
}
