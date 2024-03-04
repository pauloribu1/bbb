package coding.votacaobbbapi.service;

import coding.votacaobbbapi.model.ParticipanteModel;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class VotacaoService {

    private static final String TOPICO_VOTACAO = "votacao";
    private final KafkaTemplate<Object,Object> template;

    public void adicionarEvento(ParticipanteModel participante){
        template.send(TOPICO_VOTACAO,participante);
    }
}