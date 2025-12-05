import java.io.*;

public class CriaEscreveAtualizaAquivoJava {

    public static void main(String[] args) {

        // Criando um arquivo
        try {
            File arquivis= new File("C:\\Users\\marcu\\Documents\\arquivoJava.txt");  // Objeto criado
            if (arquivis.createNewFile()) {              // Tenta criar o arquivo
                System.out.println("Arquivo criado: " + arquivis.getName());
            } else {
                System.out.println("Arquivo já existe!");
            }
        } catch (IOException e) {
            System.out.println("Um problema ocorreu");
            e.printStackTrace(); // Mostra detalhes do erro
        }

        // Escrevendo em um arquivo mas apaga todo o contúdo existente (se o arquivo não existir, ele será criado)
        try (FileWriter escrevis = new FileWriter("C:\\Users\\marcu\\Documents\\arquivoJava.txt")) {
            escrevis.write("Minha primeira gravação em arquivos no Java.");
            System.out.println("Texto escrito no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }

        // Adicionando conteúdo a um aquivo (se o arquivo não existir, ele será criado)
        try (FileWriter adicionis = new FileWriter("C:\\Users\\marcu\\Documents\\arquivoJava.txt", true)) {
            adicionis.write("\nTexto adicionado no arquivo criado por Java.");
            System.out.println("Texto adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }

        // Outro método de escrita utilizando FileOutputStream sobrescrevendo texto
        String textoSobrescrito = "Este texto vai sobrescrever o que tiver no arquivo original!";

        try (FileOutputStream escrevis = new FileOutputStream("arquivo1.txt")) {
            escrevis.write(textoSobrescrito.getBytes());
            System.out.println("Texto escrito no arquivo com sucesso!");

        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }

        // Escrita utilizando FileOutputStream adicionando texto
        String textoAdicionado = "\nEste texto vai ser adicionado ao arquivo original!";

        try (FileOutputStream escrevis = new FileOutputStream("arquivo1.txt", true)) {
            escrevis.write(textoAdicionado.getBytes());
            System.out.println("Texto escrito no arquivo com sucesso!");

        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }

        // Escrita utilizando BufferedWriter sobrescrevendo o arquivo original
        try (BufferedWriter cachisW = new BufferedWriter(new FileWriter("arquivo1.txt"))) {
            cachisW.write("Primeira linha");
            cachisW.newLine(); // adiciona uma quebra de linha
            cachisW.write("Segunda linha");
            System.out.println("Escrita realizada com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!");
        }

        // Escrita utilizando BufferedWriter adicionando texto ao arquivo original
        try (BufferedWriter cachisW = new BufferedWriter(new FileWriter("arquivo1.txt", true))) {
            cachisW.newLine();
            cachisW.write("Esta linha será adicionada oa arquivo!");
            System.out.println("Texto adicionado ao arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo");
        }
    }
}
