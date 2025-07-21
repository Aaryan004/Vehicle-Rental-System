public abstract class Vehicle implements Rentable {
    private final String vehicleID;
    private final String modelName;
    private final double rentalRate;
    private boolean rented = false;

    public Vehicle(String vehicleID, String modelName, double rentalRate) {
        this.vehicleID = vehicleID;
        this.modelName = modelName;
        this.rentalRate = rentalRate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getModelName() {
        return modelName;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isRented() {
        return rented;
    }

    public abstract double calculateRentalCost(int days);

    @Override
    public void rentVehicle() {
        if (rented) {
            throw new IllegalStateException("Vehicle " + vehicleID + " is already rented.");
        }
        rented = true;
    }

    @Override
    public void returnVehicle() {
        if (!rented) {
            throw new IllegalStateException("Vehicle " + vehicleID + " is not currently rented.");
        }
        rented = false;
    }

    @Override
    public String toString() {
        return String.format("%s[%s] (rate=%.2f, rented=%s)",
                getClass().getSimpleName(),
                vehicleID,
                rentalRate,
                rented);
    }
}
