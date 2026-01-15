import java.io.*;
import java.util.Scanner;

public class LeArquivoJava {

    public static void main(String[] args) {

        File arquivis = new File("arquivo.txt");

        try (Scanner leris = new Scanner(arquivis)) {
            while (leris.hasNextLine()) {
                String linhas = leris.nextLine();
                System.out.println(linhas);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }

        // Obtendo informações sobre o arquivo
        System.out.println();
        if (arquivis.exists()) {
            System.out.println("Nome do arquivo: " + arquivis.getName());
            System.out.println("Absolute path: " + arquivis.getAbsolutePath());
            System.out.println("Writeable: " + arquivis.canWrite());
            System.out.println("Readable: " + arquivis.canRead());
            System.out.println("Tamanho em bytes: " + arquivis.length());
        } else {
            System.out.println("O arquivo não existe");
        }

        // Outro método de leitura utilizando o FileInputStream
        try (FileInputStream entradis = new FileInputStream("arquivo.txt")) {
            int i;
            while ((i = entradis.read()) != - 1) { // Lê byte a byte até que não tenha mais dados (-1 significa "no more data")
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }

        // Copia uma imagem
        try (FileInputStream entradis = new FileInputStream("genio2.png");
             FileOutputStream saidis = new FileOutputStream("copiaGenio.png")) {
            int i;
            while ((i = entradis.read()) != - 1) {
                saidis.write(i); // escreve o byte no novo arquivo
            }
            System.out.println("\nArquivo copiado com sucesso");
        } catch (IOException e) {
            System.out.println("\nErro ao copiar o arquivo");
        }

        // Um terceiro método de leitura é utilizando o BufferedReader
        try (BufferedReader cachisR = new BufferedReader(new FileReader("arquivo.txt"))) {
            String linha;
            while ((linha = cachisR.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
        }
    }
}
