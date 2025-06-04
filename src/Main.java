import models.CustomException;
import models.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número da sala: ");
            int number = sc.nextInt();
            System.out.print("Dia de entrada (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Dia de saída (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reserva = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Atualize sua reserva:");
            System.out.print("Nova data de entrada (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Nova data de saída (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.updateDates(checkIn, checkOut); // Este método deve existir na sua classe Reservation
            System.out.println("Reserva atualizada: " + reserva);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido");
        } catch (CustomException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inexplicavel");
        }

        sc.close();
    }
}
