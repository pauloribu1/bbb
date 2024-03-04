package votacaobbb.microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import votacaobbb.microservico.repository.VotacaoRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = VotacaoRepository.class)
public class MicroservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoApplication.class, args);
	}

}
