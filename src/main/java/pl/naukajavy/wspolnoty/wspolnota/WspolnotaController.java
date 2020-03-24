package pl.naukajavy.wspolnoty.wspolnota;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.naukajavy.wspolnoty.budynek.Budynek;
import pl.naukajavy.wspolnoty.budynek.BudynekRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class WspolnotaController {

    private WspolnotaRepository wspolnotaRepository;
    private BudynekRepository budynekRepository;

    public WspolnotaController(WspolnotaRepository wspolnotaRepository, BudynekRepository budynekRepository) {
        this.wspolnotaRepository = wspolnotaRepository;
        this.budynekRepository = budynekRepository;
    }

    @GetMapping("/wspolnota/{id}")
    public String wspolnota(@PathVariable Long id, Model model) {
        Optional<Wspolnota> wspolnotaOptional = wspolnotaRepository.findById(id);

        if (wspolnotaOptional.isPresent()) {
            Wspolnota wspolnota = wspolnotaOptional.get();
            List<Budynek> budynki = budynekRepository.findByWspolnota(wspolnota);

            model.addAttribute("wspolnota", wspolnota);
            model.addAttribute("budynki", budynki);
            return "wspolnota";
        } else {
            return "error";
        }

    }
}

