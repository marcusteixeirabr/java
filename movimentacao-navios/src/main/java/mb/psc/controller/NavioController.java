package mb.psc.controller;

import mb.psc.model.Navio;
import mb.psc.service.NavioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Navio> listarNavios(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String data,
            @RequestParam(required = false) String navio ) throws IOException {

        List<Navio> todos = navioService.getMovimentacaoNavios();

        // Filtra por status (ex.: "Fundeado")
        if (status != null) { todos = todos.stream()
            .filter(n -> n.getSituacao().equalsIgnoreCase(status))
            .toList(); 
        }
        
        // Filtra por data
        if (data != null) { todos = todos.stream()
            .filter(n -> n.getData().equalsIgnoreCase(data))
            .toList(); 
        }

        // Filtra por nome do navio
        if (navio != null) { todos = todos.stream()
            .filter(n -> n.getNavio().toLowerCase().contains(navio.toLowerCase()))
            .toList();
        }
        
        return todos;
    }
}

