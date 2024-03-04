package votacaobbb.microservico.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import votacaobbb.microservico.model.VotacaoModel;
@Repository
@AutoConfiguration
@Component
public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {
}
