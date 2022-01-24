package luna.vinicius.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Resultado {
    private boolean aceito;
    private String mensagem;
}
