import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        User user = new User(1, "neha", "123Q");

        Store store = new Store(2);

        Vehicle vehicle1 = new Vehicle(3, VehicleType.CAR, 30, 200, 20, Status.ACTIVE);
        Vehicle vehicle2 = new Vehicle(2, VehicleType.BIKE, 20, 100, 10, Status.ACTIVE);

        store.setVehicle(List.of(vehicle1, vehicle2));
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(List.of(user), List.of(store));


        System.out.println("Enter vehicle Type");
        Scanner sc = new Scanner(System.in);
        String vehicleType = sc.nextLine();

        List<Vehicle> vehicleList = store.getVehicles(vehicleType);

        System.out.println("These is the vehicle list");

        vehicleList.stream().forEach(vehicle -> System.out.println(vehicle.vehicleId));

        System.out.println("Enter vehicle ID from the above list");

        int vehicleId = sc.nextInt();

        Reservation reservation = store.createReservation(vehicleId, user);

        System.out.println("Congratulations ! Your vehicle is reserved.");
        store.startReservation(reservation);

        System.out.print("Enter Vehicle Return Date : ");
        Scanner sc1 = new Scanner(System.in);
        String dropDate = sc1.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        reservation.returnDate = LocalDate.parse(dropDate,dateTimeFormatter);

        Bill bill = new Bill(reservation);

        Payment payment = new Payment(bill);
        payment.payBill();

        store.completeReservation(reservation);
    }
}
