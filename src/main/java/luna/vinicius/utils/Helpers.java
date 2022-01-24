package luna.vinicius.utils;

public class Helpers {
    public static int getItemMenu(String texto) throws Exception{
        try{
           return Integer.parseInt(texto);
        }
        catch (Exception ex){
            throw  new Exception("Campo inválido");
        }
    }
}
