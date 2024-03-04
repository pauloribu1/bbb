package coding.votacaobbbapi.controller;

import coding.votacaobbbapi.model.ParametroModel;
import coding.votacaobbbapi.repository.ParametroRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {
    public final ParametroRepository repository;

    public ParametroController(ParametroRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/salvar")
    public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametro) {
        ParametroModel saved = repository.save(parametro);
        return ResponseEntity.ok(saved);

    }

    @GetMapping("/consultar")
    public ResponseEntity<ParametroModel> consulta(@RequestParam String chave) {
        Optional<ParametroModel> optParametro = repository.findById(chave);
        if ( optParametro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(optParametro.get());
        }
    }
}
