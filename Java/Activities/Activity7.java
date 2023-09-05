package Activities;

public class Activity7 {

    interface BicycleParts {
        public int gears = 0;
        public int currentSpeed = 0;
    }

    interface BicycleOperations {
        public void applyBrake(int decrement);
        public void speedUp(int increment);
    }
        public static void main(String args[]) {
            MountainBike mb = new MountainBike(3, 0, 25);
            System.out.println(mb.bicycleDesc());
            mb.speedUp(20);
            mb.applyBrake(5);
        }

}
