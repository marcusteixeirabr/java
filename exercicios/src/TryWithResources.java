import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {

        // Método antigo sem resources
        /*try {
            FileOutputStream saida = new FileOutputStream("arquivo.txt");
            saida.write("Olá".getBytes());
            saida.close(); // Precisa ser fechado manualmente
            System.out.println("Escrita no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!");
        }*/

        // Método pos Java 7 com resources try(...)
        try (FileOutputStream saidis = new FileOutputStream("arquivo.txt")) {
            saidis.write("Hello".getBytes());
            // Não precisa fechar manualmente
            System.out.println("Escrita no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!");
        }
    }
}
