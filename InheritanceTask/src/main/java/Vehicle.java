public class Vehicle{
    private int wheelNumber;
    private String colour;

    Vehicle(){
        this.wheelNumber = 0;
        this.colour = "nežinoma";
    }

    Vehicle(int wheelNumber, String colour){
        this();
        this.wheelNumber = wheelNumber;
        this.colour = colour;
    }

    public void vehiclePrint(){
        System.out.print("\nRatų skaičius " + wheelNumber + ", spalva " + colour);
    }
}
