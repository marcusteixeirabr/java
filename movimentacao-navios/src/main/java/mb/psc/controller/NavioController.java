package mb.psc.controller;

import mb.psc.model.Navio;
import mb.psc.service.NavioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class NavioController {

    private final NavioService navioService;

    public NavioController(NavioService navioService) {
        this.navioService = navioService;
    }

    @GetMapping("/navios")
    public List<Navio> listarNavios() throws IOException {
        return navioService.getMovimentacaoNavios();
    }
}

