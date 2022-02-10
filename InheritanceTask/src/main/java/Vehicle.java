public class Vehicle{
    private final int wheelNumber;
    private final String colour;

    Vehicle(int wheelNumber, String colour){
        this.wheelNumber = wheelNumber;
        this.colour = colour;
    }

    public void vehiclePrint(){
        System.out.print("\nRatų skaičius " + wheelNumber + ", spalva " + colour);
    }
}
