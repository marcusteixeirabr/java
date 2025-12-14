import java.util.Scanner;

public class Service {

    public static float ask_number(String pergunta, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        float answer;
        System.out.print(pergunta);
        do {
            try {
                answer = Float.parseFloat(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Digite um número válido: ");
                continue;
            }
            if (answer >= min && answer <= max) return answer;
            System.out.print("Digite um número válido: ");
        } while (true);
    }
}
