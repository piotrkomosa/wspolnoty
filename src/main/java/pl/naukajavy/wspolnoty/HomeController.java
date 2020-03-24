package pl.naukajavy.wspolnoty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private WspolnotaRepository wspolnotaRepository;

    public HomeController(WspolnotaRepository wspolnotaRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("wspolnoty", wspolnotaRepository.findAll());
        return "home";
    }
}
