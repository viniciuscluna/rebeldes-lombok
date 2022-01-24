package luna.vinicius.view;

import luna.vinicius.controller.ICController;
import luna.vinicius.model.Raca;
import luna.vinicius.utils.Helpers;

import java.util.Scanner;

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
                        System.out.println(_controller.gerarRelacaoRebeldes());
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

    private void ingressarRebelde() throws Exception {
        System.out.println("Digite seu nome:");
        var nome = _scanner.next();
        System.out.println("Olá " + nome + ", \nDigite sua idade:");
        int idade = 0;
        Raca raca = null;
        try {
            idade = _scanner.nextInt();
        } catch (Exception ex) {
            throw new Exception("Idade inválida, abortando...");
        }
        System.out.println("Beleza! Agora nos diga sua Raça: ");
        try {
            raca = Raca.valueOf(_scanner.next());
        } catch (Exception ex) {
            throw new Exception("Raça inválida, abortando...");
        }
        var resultado = _controller.solicitaInclusaoRebelde(nome, idade, raca);
        System.out.println(resultado.getMensagem());
        System.out.println("--------");
    }

    private void mensagemInicio() {
        System.out.println("Bem vindo, selecione as opções abaixo: \n");
    }

    private int mostrarMenu() throws Exception {
        System.out.println(" 1 - Solicitar ingresso rebelde \n 2 - Gerar relação de Rebeldes \n 3 - Sair");
        return Helpers.getItemMenu(_scanner.next());
    }

}
