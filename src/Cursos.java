import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Cursos {

    private String nome;
    private int alunos;

    public Cursos(String nome, int alunos) {
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
        List<Cursos> cursos = new ArrayList<Cursos>();
        cursos.add(new Cursos("Python", 45));
        cursos.add(new Cursos("JavaScript", 150));
        cursos.add(new Cursos("Java 8", 113));
        cursos.add(new Cursos("C", 55));

        //ordenar essa lista pela quantidade de alunos
        //com lambda
        cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        cursos.forEach(s -> System.out.println(s.alunos));
        System.out.println("==========");

        //com method reference
        cursos.sort(Comparator.comparing(Cursos::getAlunos));
        cursos.forEach(System.out::println); //imprime uma lista com o id de cada objeto e não o "resultado" em si
        System.out.println("==========");

        //Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos. Depois disso faça um forEach no resultado.
        cursos.stream().filter(c -> c.getAlunos() >= 50).forEach(s -> System.out.println(s.getNome()));
        System.out.println("==========");

        //Como transformar o nosso Stream<Curso> em um Stream<String> contendo apenas os nomes dos cursos?
        Stream<String> nomes = cursos.stream().map(Cursos::getNome);

        //Usando lambda
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(c -> c.getAlunos())
                .forEach(x -> System.out.println(x));

        //Usando method reference
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Cursos::getAlunos)
                .forEach(System.out::println);

    }
}


