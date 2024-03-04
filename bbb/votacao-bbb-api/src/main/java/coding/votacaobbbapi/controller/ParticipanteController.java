package coding.votacaobbbapi.controller;


import coding.votacaobbbapi.model.ParticipanteModel;
import coding.votacaobbbapi.repository.ParticipanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
@AllArgsConstructor
public class ParticipanteController {

    public final ParticipanteRepository repository;

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
        ParticipanteModel saved = repository.save(participante);
        return ResponseEntity.ok(saved);

    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consulta(@RequestParam String id) {
        Optional<ParticipanteModel> optParticipante = repository.findById(id);
        if ( optParticipante.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(optParticipante.get());
        }
    }
}
