public class Truck extends Car{
    private final int carriageSize;
    private final int carriageVolume;
    Truck(int wheelNumber, String colour, int engineSize, FuelType fuelType, int cylinders, int carriageSize, int carriageVolume) {
        super(wheelNumber, colour, engineSize, fuelType, cylinders);
        this.carriageSize = carriageSize;
        this.carriageVolume = carriageVolume;
    }

    @Override
    public void vehiclePrint() {
        super.vehiclePrint();
        System.out.print(", krovinio talpa " + carriageVolume + ", krovinio svoris " + carriageSize);
    }
}
