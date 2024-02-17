import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Store {

    int storeId;
    Location location;

    VehicleInventoryManager vehicleInventoryManager;

    List<Reservation> reservationList;

    public Store(int storeId) {
        this.storeId = storeId;
        this.location = new Location("RH-23/5", "kolkata", "WB", 700059);
        this.reservationList = new ArrayList<>();
    }

    public void setVehicle(List<Vehicle> vehicles){
        vehicleInventoryManager = new VehicleInventoryManager(vehicles);
    }

    public List<Vehicle> getVehicles(String vehicleType){
        return vehicleInventoryManager.searchVehicle(vehicleType);
    }

    public Reservation createReservation(int vehicleId, User user){
        Vehicle foundVehicle = vehicleInventoryManager.getVehicleList().stream().filter(vehicle -> vehicle.vehicleId == vehicleId).findFirst().get();
        if(foundVehicle.status.equals(Status.ACTIVE)) {
            Reservation reservation = new Reservation();
            int reservationId = reservation.createReservation(user, foundVehicle, location);
            reservationList.add(reservation);
            foundVehicle.status = Status.INACTIVE;
            return reservation;
        }
        return null;
    }

    public void startReservation(Reservation reservation){
        reservation.reservationStatus = ReservationStatus.IN_PROGRESS;
    }
    public void completeReservation(Reservation reservation){
        reservation.reservationStatus = ReservationStatus.COMPLETED;
        reservation.vehicle.status = Status.ACTIVE;
    }
}
