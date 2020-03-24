package pl.naukajavy.wspolnoty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.naukajavy.wspolnoty.budynek.Budynek;
import pl.naukajavy.wspolnoty.budynek.BudynekRepository;
import pl.naukajavy.wspolnoty.wspolnota.WspolnotaRepository;

@Controller
public class HomeController {

    private WspolnotaRepository wspolnotaRepository;
    private BudynekRepository budynekRepository;

    public HomeController(WspolnotaRepository wspolnotaRepository, BudynekRepository budynekRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
        this.budynekRepository = budynekRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("wspolnoty", wspolnotaRepository.findAll());
        return "home";
    }
}
