package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program_solucao_ruim {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Verificação ANTES de criar o objeto
        if (!checkOut.isAfter(checkIn)) {
            // Mensagem de erro e finaliza o fluxo se as datas forem inválidas
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            // Criação do objeto Reservation SOMENTE se as datas forem válidas
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            // Atualização de datas
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            LocalDate now = LocalDate.now();

            // Validação de atualização
            if (!checkOut.isAfter(checkIn)) {
                // Primeiro verifica se checkout > checkin
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            } else if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                // Depois verifica se as datas são futuras
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            } else {
                // Atualização da reserva SOMENTE se as novas datas forem válidas
                reservation.UpdateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
	}

}
