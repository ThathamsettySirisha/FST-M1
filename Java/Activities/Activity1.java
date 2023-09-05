package Activities;

public class Activity1 {

    public static void main(String[] args){

            Car carName = new Car();

           System.out.println("Calling the car methods from Activity1");
           carName.CarCharacteristics();
           carName.accelerate();
           carName.Break();
    }
}
