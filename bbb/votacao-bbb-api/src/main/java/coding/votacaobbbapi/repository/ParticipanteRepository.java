package coding.votacaobbbapi.repository;

import coding.votacaobbbapi.model.ParticipanteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {

}
