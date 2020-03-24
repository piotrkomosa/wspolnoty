package pl.naukajavy.wspolnoty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class WspolnotaController {

    private WspolnotaRepository wspolnotaRepository;

    public WspolnotaController(WspolnotaRepository wspolnotaRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
    }

    @GetMapping("/wspolnota/{id}")
    public String wspolnota(@PathVariable Long id, Model model) {
        Optional<Wspolnota> wspolnotaOptional = wspolnotaRepository.findById(id);

        if (wspolnotaOptional.isPresent()) {
            model.addAttribute("wspolnota", wspolnotaOptional.get());
            return "wspolnota";
        } else {
            return "error";
        }

    }
}

