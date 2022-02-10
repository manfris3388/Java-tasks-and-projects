public class Bycicle extends Vehicle{
    private final int gears;

    Bycicle(int wheelNumber, String colour, int gears) {
        super(wheelNumber, colour);
        this.gears = gears;
    }

    @Override
    public void vehiclePrint() {
        super.vehiclePrint();
        System.out.print(", pavarų skaičius " + gears);
    }
}
