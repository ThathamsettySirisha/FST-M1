package Activities;

public class Car {

    int make =2014;
    String color="Black";
    String transmission ="Manual";

    public void CarCharacteristics(){
        System.out.println("Car Color is"+ color);
        System.out.println("Car make year is"+ make);
        System.out.println("Car Transmission type is" + transmission);
    }
    public void accelerate(){
        System.out.println("Accelerate Method Called");
    }
    public void Break(){
        System.out.println("Break Method Called");
    }

}
