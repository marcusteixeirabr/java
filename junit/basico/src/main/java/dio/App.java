package dio;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Pessoa marcus = new Pessoa("Marcus", LocalDateTime.of(1973, 05, 10, 12, 0, 0));

        System.out.println("A idade de " + marcus.getNome() + " é " + marcus.getIdade() + " anos.");
        
        if (marcus.ehMaiorDeIdade()) {
            System.out.println("Ele é maior de idade.");
        } else {
            System.out.println("Ele é menor de indade.");
        }
    }
}
