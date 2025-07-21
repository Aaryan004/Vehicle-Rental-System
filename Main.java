public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        service.addVehicle(new Car("C001", "Toyota Camry", 100.0));
        service.addVehicle(new Bike("B001", "Yamaha R15", 30.0));
        service.addVehicle(new Truck("T001", "Ford F-150", 150.0));

        System.out.println("Available: " + service.listAvailable());

        double cost1 = service.rentVehicle("C001", 3);
        System.out.println("Rented C001 for 3 days. Cost: $" + cost1);

        double cost2 = service.rentVehicle("B001", 2);
        System.out.println("Rented B001 for 2 days. Cost: $" + cost2);

        System.out.println("Available: " + service.listAvailable());
        System.out.println("Rented:    " + service.listRented());

        service.returnVehicle("C001");
        System.out.println("Returned C001.");

        System.out.println("Available: " + service.listAvailable());
    }
}
