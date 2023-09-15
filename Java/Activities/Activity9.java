package Activities;

import java.util.ArrayList;

    public class Activity9 {
        public static void main(String[] args) {

            ArrayList<String> myList = new ArrayList<String>();
            myList.add("FST");
            myList.add("Java");
            myList.add("Activities");

            myList.add(3, "Python");
            myList.add(1, "SQL");

            System.out.println("Printing All the Objects:");
            for(String s:myList){
                System.out.println(s);
            }

            System.out.println("3rd element in the list is: " + myList.get(2));
            System.out.println("Is API is in list: " + myList.contains("API"));
            System.out.println("Size of ArrayList: " + myList.size());

            myList.remove("SQL");

            System.out.println("New Size of ArrayList: " + myList.size());
        }
    }

