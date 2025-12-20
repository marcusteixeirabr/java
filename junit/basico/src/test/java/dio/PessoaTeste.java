package dio;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTeste {

    @Test
    public void deveCalcularIdadeCorretamente() {
        Pessoa pessoa = new Pessoa("Ana", LocalDateTime.of(2000, 1, 1, 0, 0));
        Assertions.assertEquals(25, pessoa.getIdade());
    }
    
    @Test
    public void deveRetornarSeEhMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Ana", LocalDateTime.of(2000, 1, 1, 0, 0));
        Assertions.assertTrue(pessoa.ehMaiorDeIdade());

        Pessoa pessoaMenor = new Pessoa("Joao", LocalDateTime.of(2010, 1, 1, 0, 0));
        Assertions.assertFalse(pessoaMenor.ehMaiorDeIdade());
    }

}
