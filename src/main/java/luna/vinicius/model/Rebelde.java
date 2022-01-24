package luna.vinicius.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rebelde {
    private String nome;
    private int idade;
    private Raca raca;

    @Override
    public String toString() {
        return "Nome: '" + this.nome + "', Idade: '" + this.idade + "', Raça: '" + this.raca.toString() + "'";
    }
}
