package votacaobbb.microservico.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import votacaobbb.microservico.model.ParticipanteModel;
import votacaobbb.microservico.model.VotacaoModel;
import votacaobbb.microservico.repository.VotacaoRepository;

import java.util.Date;


@Service
@Slf4j
@AllArgsConstructor
public class MicroservicoService{

    @Autowired
    private final VotacaoRepository repository;

    @KafkaListener(topics="votacao",groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro){

        String participanteStr = registro.value();
        log.info("Voto recebido = {}", participanteStr);

        ParticipanteModel participante = null;
        ObjectMapper mapper = new ObjectMapper();

        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entidade = repository.save(votacao);

        try{
            participante = mapper.readValue(participanteStr,ParticipanteModel.class);
        } catch(JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}],", participanteStr, ex);
            return;

        }

        log.info("Voto registrado com sucesso (id = {}, dataHora={})", entidade.getId(), entidade.getDataHora());
    }
}
