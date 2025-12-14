import java.util.Scanner;
import java.time.Year;

public class Main {

    public static void main(String[] args) {

        Scanner teclis = new Scanner(System.in);
        System.out.print("Digite o ano de nascimento: ");
        int anoNascimento = teclis.nextInt();
        int anoAtual = Year.now().getValue();
        int idade = anoAtual - anoNascimento;
        System.out.println("Sua idade é " + idade + " anos.");
        System.out.print("Você é uma pessoa ");
        if (idade >= 18) {
            System.out.println("maior de idade.");
        } else {
            System.out.println("menor de idade.");
        }
    }
}