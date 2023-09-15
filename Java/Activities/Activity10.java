package Activities;

import java.util.HashSet;

    public class Activity10 {
        public static void main(String[] args) {
            HashSet<String> hs = new HashSet<String>();
            // Adding element to HashSet
            hs.add("One");
            hs.add("Two");
            hs.add("Three");
            hs.add("Four");
            hs.add("Five");
            hs.add("Six");

            System.out.println("Original HashSet: " + hs);
            System.out.println("Size of HashSet: " + hs.size());

            System.out.println("Removing A from HashSet: " + hs.remove("Five"));
            //Remove element that is not present
            if(hs.remove("Ten")) {
                System.out.println("Ten removed from the Set");
            } else {
                System.out.println("Ten is not present in the Set");
            }

            System.out.println("Checking if One is present: " + hs.contains("One"));
            System.out.println("Updated HashSet: " + hs);
        }
    }

