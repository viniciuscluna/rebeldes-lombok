package luna.vinicius.view;

import luna.vinicius.controller.ICController;
import luna.vinicius.model.OrdemRelatorio;
import luna.vinicius.model.Raca;
import luna.vinicius.model.RetornoRelatorio;
import luna.vinicius.utils.Helpers;

import java.util.Scanner;

import static luna.vinicius.utils.Validador.ValidarIdade;
import static luna.vinicius.utils.Validador.ValidarRaca;

public class ICView {
    private Scanner _scanner;
    private ICController _controller;

    public ICView(Scanner scanner) throws Exception {
        _scanner = scanner;
        _controller = new ICController();
        mensagemInicio();
        controleAplicacao();
    }

    private void controleAplicacao() throws Exception {
        while (true) {
            try {
                switch (mostrarMenu()) {
                    case 1:
                        ingressarRebelde();
                        break;
                    case 2:
                        tratarRelatorioRebeldes();
                        break;
                    case 3:
                        System.out.println("Até mais :)");
                        return;
                    default:
                        throw new Exception("Opção inválida");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    private void tratarRelatorioRebeldes() throws Exception {
        System.out.println("Beleza!\n Antes de gerar o relatório, gostaríamos de saber você gostaria de ordenar os rebeldes:");
        System.out.println("1 - Nome\n2 - Idade\n3 - Raça\nQualquer outra tecla não irá ordenar ;)");
        RetornoRelatorio retornoRelatorio = new RetornoRelatorio();
        switch (_scanner.next()){
            case "1":
                retornoRelatorio = _controller.gerarRelacaoRebeldes(OrdemRelatorio.Nome);
                break;
            case "2":
                retornoRelatorio = _controller.gerarRelacaoRebeldes(OrdemRelatorio.Idade);
                break;
            case "3":
                retornoRelatorio = _controller.gerarRelacaoRebeldes(OrdemRelatorio.Raca);
                break;
            default:
                retornoRelatorio = _controller.gerarRelacaoRebeldes(OrdemRelatorio.Nenhum);
                break;
        }

        System.out.println("Relatório abaixo:");
        System.out.println(retornoRelatorio.getLista());
        System.out.println("Resultado geração arquivo: " + retornoRelatorio.getResultadoArquivo());

    }

    private void ingressarRebelde() throws Exception {
        int idade = 0;
        Raca raca = null;
        String nome = "";
        System.out.println("Digite seu nome:");
        try {
            nome = _scanner.next();
            System.out.println("Olá " + nome + ", \nDigite sua idade:");
            idade = ValidarIdade(_scanner);
            System.out.println("Beleza! Agora nos diga sua Raça: ");
            raca = ValidarRaca(_scanner);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        var resultado = _controller.solicitaInclusaoRebelde(nome, idade, raca);
        System.out.println(resultado.getMensagem());
        System.out.println("--------");
    }

    private void mensagemInicio() {
        System.out.println("Bem vindo, selecione as opções abaixo: \n");
    }

    private int mostrarMenu() throws Exception {

        System.out.println("\n1 - Solicitar ingresso rebelde \n 2 - Gerar relação de Rebeldes \n 3 - Sair");
        return Helpers.getItemMenu(_scanner.next());
    }

}
