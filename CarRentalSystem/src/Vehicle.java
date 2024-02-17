public class Vehicle {
    int vehicleId;
    VehicleType vehicleType;
    int kmsTravelled;

    int dailyRentalCost;
    int hourlyRentalCost;

    Status status;

    public Vehicle(int vehicleId, VehicleType vehicleType, int kmsTravelled, int dailyRentalCost, int hourlyRentalCost, Status status) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.kmsTravelled = kmsTravelled;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.status = status;
    }
}
