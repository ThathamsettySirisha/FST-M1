package Activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] A = {10, 77, 10, 54, -11, 10};

        int temp = 0;
        int length = A.length;
        for (int i = 0; i <= length-1; i++) {
            if (A[i] == 10) {
                temp = temp + A[i];
            }
        }

        if (temp == 30) {
            System.out.println("Sum of all the 10's in the array is exactly 30");
        } else
            System.out.println("Sum of all the 10's in the array is not equals to 30");
    }
}