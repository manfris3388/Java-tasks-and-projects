public class CarApp {
    public static void main(String[] args) {
        System.out.println("hello");
        Vehicle vehicle = new Vehicle(0, "nežinoma");
        vehicle.vehiclePrint();
        Car car = new Car(4, "pilka", 2000, FuelType.PETROL, 4);
        car.vehiclePrint();
        Bycicle bycicle = new Bycicle(2, "mėlyna", 3);
        bycicle.vehiclePrint();
        Truck truck = new Truck(6, "raudona", 5000, FuelType.DIESEL, 8, 10, 30);
        truck.vehiclePrint();
    }

}
