import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
        Consumer consumer = new ConsumidorPalavras();
        palavras.forEach(consumer);

        //Antes do Java 8, ordena por ordem alfabetica
        Collections.sort(palavras);
        System.out.println(palavras);

        //Java 8, ordena por ordem de tamanho.
        ComparadorDeTamanhos comparador = new ComparadorDeTamanhos();
        palavras.sort(comparador);
        System.out.println(palavras);
    }
}

class ConsumidorPalavras implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorDeTamanhos implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() > s2.length())
            return 1;
        if(s1.length() < s2.length())
            return -1;
        return 0;
    }
}
