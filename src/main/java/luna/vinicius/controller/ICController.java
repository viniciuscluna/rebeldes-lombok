package luna.vinicius.controller;

import luna.vinicius.model.*;

import java.io.*;
import java.util.*;

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

    public RetornoRelatorio gerarRelacaoRebeldes(OrdemRelatorio ordemRelatorio) throws Exception {
        var lista = ordenarLista(rebeldes.getRebeldes(), ordemRelatorio);
        return new RetornoRelatorio(gravarArquivo(lista), gerarListaCompilada(lista));
    }


    private String gerarListaCompilada(Rebelde[] rebeldes) {
        StringBuilder sb = new StringBuilder();

        for (Rebelde rebelde : rebeldes) {
            sb.append(rebelde.toString() + "\n");
        }

        return sb.toString();
    }

    private Rebelde[] ordenarLista(Queue<Rebelde> rebeldes, OrdemRelatorio ordemRelatorio) {
        var vetor = rebeldes.toArray(Rebelde[]::new);
        if (ordemRelatorio == OrdemRelatorio.Nenhum) return vetor;

        int tamanho = vetor.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (checkCondicao(vetor, j, ordemRelatorio)) {
                    var auxiliar = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = auxiliar;
                }
            }
        }

        return vetor;
    }

    private boolean checkCondicao(Rebelde[] rebeldes, int posicao, OrdemRelatorio ordemRelatorio) {
        switch (ordemRelatorio) {
            case Idade:
                return rebeldes[posicao].getIdade() > rebeldes[posicao + 1].getIdade();
            case Nome:
                return rebeldes[posicao].getNome().compareTo(rebeldes[posicao + 1].getNome()) > 0;
            case Raca:
            default:
                return rebeldes[posicao].getRaca().toString().compareTo(rebeldes[posicao + 1].getRaca().toString()) > 0;
        }
    }

    private String gravarArquivo(Rebelde[] rebeldes) throws Exception {
        try {
            OutputStream os = new FileOutputStream("arquivo.txt");
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            br.write("Relação de Rebeldes aprovados abaixo:");
            br.newLine();
            for (Rebelde rebelde : rebeldes) {
                br.write(rebelde.toString());
                br.newLine();
            }
            br.close();
            return "Arquivo criado com sucesso, verifique na pasta do projeto";
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar o arquivo, tente novamente");
        }
    }
}
