import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;

public class ColecoesJava {

    public static void main(String[] args) {

        // Um ArrayList é uma matriz redimensionável que pode crescer conforme necessário.
        // Ele permite armazenar elementos e acessá-los por índice.
        ArrayList<String> carros = new ArrayList<String>();
        carros.add("Volvo");
        carros.add("BMW");
        carros.add("Ford");
        carros.add("Mazda");
        carros.add("BYD");

        System.out.println(carros);
        Collections.sort(carros); // A ordenação é necessária antes de usar binarySearch

        int index = Collections.binarySearch(carros, "Mazda");
        System.out.println(index);
        System.out.println(carros.get(index + 1));

        System.out.println(carros);
        carros.sort(Collections.reverseOrder()); // Ou Collections.sort(carros, Collections.reverseOrder())
        System.out.println(carros);

        ArrayList<Integer> enderecos = new ArrayList<>();
        enderecos.add(10);
        enderecos.add(20);
        enderecos.add(30);
        enderecos.add(50);
        enderecos.add(50);
        System.out.println(enderecos);

        // Um HashSet é uma coleção onde cada elemento é único - não são permitidas duplicatas.
        HashSet<String> frutas = new HashSet<String>();
        frutas.add("Laranja");
        frutas.add("Banana");
        frutas.add("Maçã");
        frutas.add("Pêra");
        frutas.add("Uva");
        frutas.add("Banana");   // No exemplo acima, embora o BMW seja adicionado duas vezes, ele só aparece uma vez no
                                // conjunto porque cada elemento de um conjunto deve ser único.
        System.out.println(frutas);

        TreeSet<String> formas = new TreeSet<>();
        formas.add("Triângulo");
        formas.add("Retângulo");
        formas.add("Círculo");
        formas.add("Trapézio");

        System.out.println(formas);

        // Um HashMap armazena pares chave-valor (key-value), que são ótimos quando você deseja armazenar valores e
        // encontrá-los por uma chave (como um nome ou ID):
        HashMap<String, String> capitais = new HashMap<>();
        capitais.put("Inglaterra", "Londres");
        capitais.put("Brasil", "Brasília");
        capitais.put("Alemanha", "Berlim");
        capitais.put("Itália", "Roma");
        System.out.println(capitais);

        // Criar um iterador para uma ArrayList
        Iterator<String> itis = carros.iterator();

        while (itis.hasNext()) {
            System.out.print(itis.next() + " ");
        }
        System.out.println();

        // Sem uso de iterador
        for (String carro : carros) {
            System.out.print(carro + ", ");
        }
        System.out.println();
        for (String capital : capitais.values()) {
            System.out.print(capital + " ");
        }
        System.out.println();
        int[] numeros = {1, 2, 3};
        numeros[0] = 5;

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println();

        var colecoes = new ArrayList<HashSet<String>>();
        var amigos = new HashSet<String>();
        var pets = new HashSet<String>();
        var jogos = new HashSet<String>();
        amigos.add("Willian");
        amigos.add("Maurício");
        amigos.add("Novak");
        pets.add("Aramis");
        pets.add("Donatelo");
        pets.add("Areta");
        jogos.add("Ragnarok");
        jogos.add("WoW");
        jogos.add("Civilization");
        colecoes.add(amigos);
        colecoes.add(pets);
        colecoes.add(jogos);

        System.out.println(colecoes.get(1));

        int conta = Collections.frequency(enderecos, 50);
        System.out.println(conta);
        boolean tem = enderecos.contains(10);
        System.out.println(tem);
        int ini = enderecos.indexOf(20);

        System.out.println(ini);

        pets.forEach((n) -> { System.out.print(n + ", "); });

        System.out.println();
        Consumer<String> metodo = (m) -> {System.out.print(m + ", "); };

        jogos.forEach(metodo);




    }
}
