import java.util.List;

import static java.util.stream.Collectors.toList;

public class VehicleInventoryManager {

    List<Vehicle> vehicleList;

    public VehicleInventoryManager(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> searchVehicle(String vehicleType){
        return vehicleList.stream().filter((vehicle) -> {
            if (vehicleType.equals("CAR")) {
                return vehicle.vehicleType.equals(VehicleType.CAR);
            } else if (vehicleType.equals("BIKE")) {
                return vehicle.vehicleType.equals(VehicleType.BIKE);
            }
            return false;
        }
        ).collect(toList());
    }
}
