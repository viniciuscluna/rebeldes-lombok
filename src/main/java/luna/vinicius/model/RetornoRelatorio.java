package luna.vinicius.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoRelatorio {
    private String resultadoArquivo;
    private String lista;
}
