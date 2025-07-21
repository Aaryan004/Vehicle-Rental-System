import java.util.*;

public class RentalService {
    private final Map<String, Vehicle> available = new HashMap<>();
    private final Map<String, Vehicle> rented    = new HashMap<>();

    public void addVehicle(Vehicle v) {
        available.put(v.getVehicleID(), v);
    }

    public double rentVehicle(String vehicleID, int days) {
        Vehicle v = available.get(vehicleID);
        if (v == null) {
            throw new NoSuchElementException("Vehicle " + vehicleID + " not available.");
        }
        v.rentVehicle();
        double cost = v.calculateRentalCost(days);
        available.remove(vehicleID);
        rented.put(vehicleID, v);
        return cost;
    }

    public void returnVehicle(String vehicleID) {
        Vehicle v = rented.get(vehicleID);
        if (v == null) {
            throw new NoSuchElementException("Vehicle " + vehicleID + " is not rented.");
        }
        v.returnVehicle();
        rented.remove(vehicleID);
        available.put(vehicleID, v);
    }

    public List<Vehicle> listAvailable() {
        return new ArrayList<>(available.values());
    }

    public List<Vehicle> listRented() {
        return new ArrayList<>(rented.values());
    }
}
