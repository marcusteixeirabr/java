import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("-=-=-=-=-=-=".repeat(5));
        System.out.println("              C Á L C U L O  D E  F R E T E");
        System.out.println("-=-=-=-=-=-=".repeat(5));
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        Frete frete1 = new Frete();

        frete1.setRouteDistance(Service.ask_number("Qual a distância do transporte em km? ", 100, 10000));

        frete1.setParts((int) Service.ask_number("Digite a quantidade de peças que deseja transportar: ", 100, 10000));

        System.out.println("1 - Sul");
        System.out.println("2 - Sudeste");
        System.out.println("3 - Centro-Oeste");
        frete1.setRoutRegion((int) Service.ask_number("Qual a região de destino do transporte: ", 1, 3));

        boolean answered = false;
        System.out.print("Gostaria de rastrear o transporte? [S/N] ");
        do {
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "s", "sim", "y", "yes" -> {
                    frete1.setTrack(true);
                    answered = true;
                }
                case "n", "nao", "não", "no", "not" -> {
                    frete1.setTrack(false);
                    answered = true;
                }
                default -> System.out.print("Digite S ou N : ");
            }
        } while (!answered);

        System.out.println();
        System.out.println("-=-=-=-=-=-=".repeat(5));
        System.out.printf("Taxa do rastreamento: R$ %.2f\n", frete1.calculateTrackFreight());
        System.out.printf("Valor do frete pelas peças: R$ %.2f\n", frete1.calculatePartsFreight());
        System.out.printf("Valor do frete por quilômetro: R$ %.2f\n", frete1.calculateFreightPerKM());
        System.out.printf("Total do frete: R$ %.2f\n", frete1.calculateTotalFreight());
        System.out.println("-=-=-=-=-=-=".repeat(5));


    }
}