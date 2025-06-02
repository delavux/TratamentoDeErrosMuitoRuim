import models.entites.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");

        System.out.println("Numero da sala: ");
        int number = sc.nextInt();
        System.out.println(" Reserve seu dia de chegagem! A checagem deve ser nesse formato: (dd/MM/yyyy) ");
        Date checagem = sdf.parse(sc.next());
        System.out.print("A saida deve ser nesse formto (dd/MM/yyyy): ");
        Date saida = sdf.parse(sc.next());

        if (!saida.after(checagem)) {
            System.out.println("Erro na reserva: a Saida deve ser depois do dia da checagem!");
        }
        else {
            Reservation reserva = new Reservation(number, checagem, saida);
            System.out.println("Reserva : " + reserva);

            System.out.println();
            System.out.println("Coloque a data para atualizar sua reserva: ");
            System.out.println(" Reserve seu dia de chegagem! A checagem deve ser nesse formato: (dd/MM/yyyy) ");
             checagem = sdf.parse(sc.next());

             Date now = new Date();
             if (checagem.before(now) || saida.before(now)) {
                 System.out.println("Erro na reserva: a data da reserva deve ser feita bo futuro!");
             }
             else if (!saida.after(checagem)){
                 System.out.println("Erro na reserva: a Saida deve ser depois do dia da checagem!");
             }
             else {
                 reserva.atualizarHospedagem(number, checagem, saida);
                 System.out.println("REserva : " + reserva);
             }







            System.out.print("A saida deve ser nesse formto (dd/MM/yyyy): ");
             saida = sdf.parse(sc.next());
             reserva.atualizarHospedagem(number, checagem, saida);

        }
    }
}