import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public class OrdenaStrings {

    public static void main(String[] args) {



        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        // Modo antigo de imprimir antes do Java 8
//        for (String s : palavras){
//            System.out.println(s);
//        }

        //Nova maneira de imprimir no Java 8
//        Consumer consumer = new ConsumidorPalavras();
//        palavras.forEach(consumer);

        //Nova maneira de imprimir no Java 8 com Lambda
        palavras.forEach(s -> System.out.println(s));

        //imprime lista com method reference
        palavras.forEach(System.out::println);

        //Antes do Java 8, ordena por ordem alfabetica
        Collections.sort(palavras);
        System.out.println(palavras);

        //Java 8, ordena por ordem de tamanho.
//        ComparadorDeTamanhos comparador = new ComparadorDeTamanhos();
//        palavras.sort(comparador);
//        System.out.println(palavras);

        //Java 8, ordena por ordem de tamanho com lambda
        //Conhecendo a API, podemos utilizar o metodo compare da classe Integer


//        palavras.sort((s1, s2) -> {
//            return Integer.compare(s1.length(), s2.length());
//        });

        //deixando mais curto com lambda
        palavras.sort(comparing(s->s.length()));

        //deixando mais curto ainda com method reference
        palavras.sort(comparing(String::length));

        //ou
        // desse jeito vc importa a Collection de maneira estatica
        palavras.sort(comparing(String::length));

        //ou
        palavras.sort(String.CASE_INSENSITIVE_ORDER);


        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();

        //com lambda
        new Thread(()-> System.out.println("Executando um Runnable")).start();
    }
}

//class ConsumidorPalavras implements Consumer<String>{
//
//    @Override
//    public void accept(String s) {
//        System.out.println(s);
//    }
//}

//class ComparadorDeTamanhos implements Comparator<String>{
//
//    @Override
//    public int compare(String s1, String s2) {
//        if(s1.length() > s2.length())
//            return 1;
//        if(s1.length() < s2.length())
//            return -1;
//        return 0;
//    }
//}
