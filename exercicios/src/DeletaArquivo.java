import java.io.File;

public class DeletaArquivo {

    public static void main(String[] args) {

        // Deleta um arquivo
        File arquivis = new File("meuarquivo.txt");
        if (arquivis.delete()) {
            System.out.println("Arquivo " + arquivis.getName() + " deletado com sucesso!");
        } else {
            System.out.println("Falha ao tentar deletar o aquivo " + arquivis.getName());
        }

        // Deleta um diretório
        File diretoris = new File("Teste");
        if (diretoris.delete()) {
            System.out.println("Diretório " + diretoris.getName() + " deletado com sucesso!");
        } else {
            System.out.println("Erro ao tentar deletar o diretório " + diretoris.getName());
        }
    }
}
