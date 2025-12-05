import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Carro {
    String marca, modelo;
    int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
}

// Cria o comparador
class SortByYear implements Comparator {

    public int compare(Object obj1, Object obj2) {
        Carro a = (Carro) obj1;
        Carro b = (Carro) obj2;

        // Compara o ano dos dois objetos. Pode-se usar return Integer.compare(a.ano, b.ano);
        if (a.ano < b.ano) return - 1; // O primeiro carro é mais novo
        if (a.ano > b.ano) return 1;   // O primeiro carro é mais velho
        return 0;
    }
}

class SortEvenFirst implements Comparator {

    public int compare(Object obj1, Object obj2) {
        // Certifique-se que os objetos são Integer
        var a = (Integer) obj1;
        var b = (Integer) obj2;

        //Verifica de cada número é par
        boolean aIsEven = (a % 2) == 0;
        boolean bIsEven = (b % 2) == 0;

        if (aIsEven == bIsEven) {

            // Se ambos os números forem pares ou ímpares seguirão as regras normais
            if (a < b) return -1; // Pode-se usar return a.compareTo(b)
            if (a > b) return 1;
            return 0;
        } else {

            // Se a for par vai para frente de b, de outro modo b vai para frente
            if (aIsEven) {
                return - 1;
            } else {
                return 1;
            }
        }
    }
}

public class ComparacaoAvancada {

    public static void main(String[] args) {

        // Ordena uma lista de objetos carros
        // Cria uma lista de carros
        var meusCarros = new ArrayList<Carro>();
        meusCarros.add(new Carro("BMW", "X5", 1999));
        meusCarros.add(new Carro("Honda", "Accord", 2006));
        meusCarros.add(new Carro("Ford", "Mustang", 1970));

        // Usa o comparador para classificar os carros
        Comparator minhaComparacao = new SortByYear();
        Collections.sort(meusCarros, minhaComparacao);

        // Mostra os carros
        for (Carro c : meusCarros) {
            System.out.println(c.marca + " " + c.modelo + " " + c.ano);
        }

        System.out.println("-=".repeat(10));

        // Usa expressão lambda para classificar os carros
        Collections.sort(meusCarros, (obj1, obj2) -> {
            Carro a = (Carro) obj1;
            Carro b = (Carro) obj2;
            if (a.ano > b.ano) return - 1;
            if (a.ano < b.ano) return 1;
            return 0;
        });

        // Mostra os carros
        for (Carro c : meusCarros) {
            System.out.println(c.marca + " " + c.modelo + " " + c.ano);
        }

        System.out.println("-=".repeat(10));

        // Ordena uma lista de objetos números
        // Cria uma lista de números
        ArrayList<Integer> meusNumeros = new ArrayList<>();
        meusNumeros.add(33);
        meusNumeros.add(13);
        meusNumeros.add(24);
        meusNumeros.add(12);
        meusNumeros.add(8);
        meusNumeros.add(3);
        meusNumeros.add(50);

        Comparator minhaClassificacao = new SortEvenFirst();
        Collections.sort(meusNumeros, minhaClassificacao);

        meusNumeros.forEach((f) -> { System.out.print(f + ", "); });
    }
}
