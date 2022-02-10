public class Car extends Vehicle {
    private final int engineSize;
    private final FuelType fuelType;
    private final int cylinders;

    Car(int wheelNumber, String colour, int engineSize, FuelType fuelType, int cylinders) {
        super(wheelNumber, colour);
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.cylinders = cylinders;
    }

    @Override
    public void vehiclePrint() {
        super.vehiclePrint();
        System.out.print(", variklio tūris " + engineSize + ", kuro tipas " + fuelType +
                ", cilindrų skaičius " + cylinders);
    }
}
