package classes;

public class App {
    
    public static void main(String[] args) throws Exception {
        int numero;
        numero = soma(1, 2);
        System.out.println("Olá Java do Visual Studio Code o número é: " + numero);
    }


    public static int soma(int num1, int num2) {
        return num1 + num2;
    }

}