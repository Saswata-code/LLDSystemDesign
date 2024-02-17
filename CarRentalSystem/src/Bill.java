import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bill {

    Reservation reservation;
    boolean isPaid;
    int amount;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.isPaid=false;
        this.amount= computeBill();
    }
    public int computeBill(){
        LocalDate pickUpDate =  reservation.pickUpDate;
        LocalDate returnDate = reservation.returnDate;
        int dailyCost = reservation.vehicle.dailyRentalCost;
        int days = (int)ChronoUnit.DAYS.between(pickUpDate, returnDate);
        return dailyCost*days;
    }
}
