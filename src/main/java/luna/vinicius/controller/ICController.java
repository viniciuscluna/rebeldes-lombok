package luna.vinicius.controller;

import luna.vinicius.model.ICRebelde;
import luna.vinicius.model.Raca;
import luna.vinicius.model.Rebelde;
import luna.vinicius.model.Resultado;
import luna.vinicius.utils.Helpers;

import java.io.*;
import java.util.Random;

public class ICController {
    private ICRebelde rebeldes;

    public ICController() {
        rebeldes = new ICRebelde();
    }
    Random rd = new Random();
    public Resultado solicitaInclusaoRebelde(String nome, int idade, Raca raca) {
        if (rd.nextBoolean()) {
            rebeldes.addRebelde(new Rebelde(nome, idade, raca));
            return new Resultado(true, "Parabéns você foi aceito com êxito");
        } else {
            return new Resultado(false, "Que pena :(, não foi dessa vez");
        }

    }

    public String gerarRelacaoRebeldes() throws IOException {

        OutputStream os = new FileOutputStream("arquivo.txt");
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

        br.write("Relação de Rebeldes aprovados abaixo:");
        br.newLine();
        for (Rebelde rebelde : rebeldes.getRebeldes()) {
            br.write(rebelde.toString());
            br.newLine();
        }

        br.close();

        return "Arquivo criado com sucesso, verifique na pasta do projeto";
    }
}
