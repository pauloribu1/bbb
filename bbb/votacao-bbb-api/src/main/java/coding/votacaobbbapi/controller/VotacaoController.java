package coding.votacaobbbapi.controller;

import coding.votacaobbbapi.model.ParticipanteModel;
import coding.votacaobbbapi.service.VotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class VotacaoController {

    private final VotacaoService service;
    @PostMapping("/votar")
    public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante) {
        service.adicionarEvento(participante);
        return ResponseEntity.ok("Voto registrado com sucesso.");
    }
}
