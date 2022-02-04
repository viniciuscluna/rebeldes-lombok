package luna.vinicius.utils;

import luna.vinicius.model.Raca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    public static int ValidarIdade(Scanner _scanner) throws Exception{
        try{
            var idade = _scanner.nextInt();
            if(idade < 0 ) throw new Exception("Idade não pode ser negativa :(");
            return idade;
        }catch (InputMismatchException ex){
            throw new Exception("Idade inválida");
        }
    }
    public static Raca ValidarRaca(Scanner _scanner) throws Exception{
        try{
            return Raca.valueOf(_scanner.next());
        }catch (InputMismatchException ex){
            throw new Exception("Raça inválida");
        }
    }
}
