package votacaobbb.microservico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("votacao")
public class VotacaoModel {

    @Id
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String Id;
    private ParticipanteModel participante;
    private Date dataHora;

}
