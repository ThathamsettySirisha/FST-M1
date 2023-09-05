package Activities;

public class Activity3 {

    public static void main(String [] args) {

        double ageInseconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        double AgeInYears_Earth = ageInseconds/EarthSeconds;
        double AgeInYears_Mercury = ageInseconds/MercurySeconds;
        double AgeInYears_Venus = ageInseconds/VenusSeconds;
        double AgeInYears_Mars = ageInseconds/MarsSeconds;
        double AgeInYears_Jupiter =ageInseconds/JupiterSeconds;
        double AgeInYears_Saturn =ageInseconds/SaturnSeconds;
        double AgeInYears_Uranus =ageInseconds/UranusSeconds;
        double AgeInYears_Neptune =ageInseconds/NeptuneSeconds;

        System.out.println("Age on Earth is " + AgeInYears_Earth);
        System.out.println("Age on Mercury is " + AgeInYears_Mercury);
        System.out.println("Age on Venus is " + AgeInYears_Venus);
        System.out.println("Age on Mars is" + AgeInYears_Mars);
        System.out.println("Age on Jupiter is" + AgeInYears_Jupiter);
        System.out.println(" Age on Saturn is" + AgeInYears_Saturn);
        System.out.println("Age on Uranus is" + AgeInYears_Uranus);
        System.out.println("Age on Neptune is" + AgeInYears_Neptune);

    }
}
