public class Bike extends Vehicle {
    public Bike(String vehicleID, String modelName, double rentalRate) {
        super(vehicleID, modelName, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        double base = getRentalRate() * days;
        return base * 0.8;
    }
}
