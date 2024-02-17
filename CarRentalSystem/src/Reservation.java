import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Reservation {

    int reservationId;
    User user;
     ReservationStatus reservationStatus;

     Vehicle vehicle;

     LocalDate reservationDate;
     LocalDate pickUpDate;
     LocalDate returnDate;

     Location pickUpLocation;

     Location dropLocation;

    public int createReservation(User user, Vehicle vehicle, Location location){
        this.reservationDate = LocalDate.now();
        this.user = user;
        this.vehicle = vehicle;
        this.reservationId = (int)(Math.random()*100 +1);
        System.out.println("Enter pickUp date:");
        Scanner sc2 = new Scanner(System.in);

        String pickUpDate = sc2.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.pickUpDate = LocalDate.parse(pickUpDate, dateTimeFormatter);
        this.pickUpLocation = location;
        this.dropLocation = location;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
