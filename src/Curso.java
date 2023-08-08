import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }


    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        //ordenar essa lista pela quantidade de alunos
        //com lambda
        cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        cursos.forEach(s -> System.out.println(s.alunos));
        System.out.println("==========");

        //com method reference
        cursos.sort(Comparator.comparing(Curso::getAlunos));
        cursos.forEach(System.out::println); //imprime uma lista com o id de cada objeto e não o "resultado" em si
        System.out.println("==========");

        //Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos. Depois disso faça um forEach no resultado.
        cursos.stream().filter(c -> c.getAlunos() >= 50).forEach(s -> System.out.println(s.getNome()));
        System.out.println("==========");

        //Como transformar o nosso Stream<Curso> em um Stream<String> contendo apenas os nomes dos cursos?
        Stream<String> nomes = cursos.stream().map(Curso::getNome);

        //Usando lambda
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(c -> c.getAlunos())
                .forEach(x -> System.out.println(x));

        //Usando method reference
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        //Pegar o primeiro elemento com o Stream
        //Optional<Cursos> first =
                cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();

        // a quantidade média de alunos de todos os seus cursos utilizando a API de Stream.
        //OptionalDouble average =
                cursos.stream().mapToInt(c -> c.getAlunos()).average();

        //Como podemos transformar esse Stream<Curso> filtrado em uma List<Curso>?

        Stream<Curso> stream = cursos.stream()
                .filter(c -> c.getAlunos() > 50);

        //guardado em uma lista
        List<Curso> collect = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toList());
    }
}


