// try ... catch ... finally
public class TryCatchFinallyThrow {

    public static void main(String[] args) {
        try {
            int[] meusNumeros = {1, 2, 3};
            System.out.println(meusNumeros[10]);
            int resultado = 10 / 0;

        /*} catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Índice de matriz inexistente."); // Vai ser executada a primeira exceção
            System.out.println(error);

        } catch (ArithmeticException err) {
            System.out.println("Impossível divisão por zero.");
            System.out.println(err);*/

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro matemático ou de matriz"); // Captura de exceção múltipla
            System.out.println(e);

        } catch (Exception erro) {
            System.out.println("Alguma coisa deu errado!");
            System.out.println(erro);

        } finally {
            System.out.println("Try ... Catch finalizado.");
        }
    }
}

// throw new ... Criando nova Exceção
/*public class TryCatchFinallyThrow {

    static void chequeIdade(int idade) {
        if (idade < 18) {
            throw new ArithmeticException("Acesso negado - Você precisa ter pelo menos 18 anos de idade.");
        } else {
            System.out.println("Acesso autorizado - Você tem idade suficiente!");
        }
    }

    public static void main(String[] args) {
        chequeIdade(20);
    }
}*/

