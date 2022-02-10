import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class ExampleMain {
    public static void main(String[] args) {

        List<String> listOfEachLine = new ArrayList<>();

        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // add each line to my list
                listOfEachLine.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // create a list of PersonWithDays
        List<PersonWithDays> personWithDaysList = new ArrayList<>();

        // iterate my list to print in console each line
        for (String line: listOfEachLine) {
            System.out.println(line);
            String[] splitNameAndDays = line.split("=");

            String name = splitNameAndDays[0];
            System.out.println(name); // name

            String daysAsString = splitNameAndDays[1];
            System.out.println(daysAsString); // days

            List<String> daysAsList = Arrays.asList(daysAsString.split(","));

            PersonWithDays personWithDays = new PersonWithDays(name, daysAsList);

            personWithDaysList.add(personWithDays);
        }


        // iterate my list of PersonWithDaysList
        for (PersonWithDays personWithDays: personWithDaysList) {
            System.out.println(personWithDays.toString());
        }

    }
}
