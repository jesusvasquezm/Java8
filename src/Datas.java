import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {

        LocalDate agora = LocalDate.now();
        System.out.println(agora);
        System.out.println("=================");

        LocalDate futuraData = LocalDate.of(2099, Month.JANUARY, 25);
        System.out.println(futuraData);
        System.out.println("=================");

        //Mostrar a diferença das datas entre agora e a futura data
        Period periodo = Period.between(agora, futuraData);
        System.out.println(periodo);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime data = LocalDateTime.now(); //Necessário usar o LocalDateTime para imprimir uma data sem usar as horas nem minutos
        String formatado = data.format(formatador);
        System.out.println(formatado);

    }
}
