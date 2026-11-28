package bg.softuni.crystal.web;

import bg.softuni.crystal.domain.dtos.binding.ReservationCreateDto;
import bg.softuni.crystal.repositories.TableRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final TableRepository tableRepository;

    public ReservationController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new ReservationCreateDto());
        model.addAttribute("tables", tableRepository.findAll());

        return "reservations/new";
    }
}
