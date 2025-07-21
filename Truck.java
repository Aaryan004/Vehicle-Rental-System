public class Truck extends Vehicle {
    public Truck(String vehicleID, String modelName, double rentalRate) {
        super(vehicleID, modelName, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 50.0;
    }
}
