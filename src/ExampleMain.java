import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExampleMain {
    public static void main(String[] args) {

        // read from file
        List<String> listOfEachLineFromFile = readLinesFromFile("data.txt");


        // create a list of PersonWithDays
        List<PersonWithDays> personWithDaysList = getListOfPeople(listOfEachLineFromFile);


        // print my list in the console
        printListOfPeopleWithDays(personWithDaysList);

    }

    public static List<String> readLinesFromFile(String pathFile) {
        List<String> listOfEachLineFromFile = new ArrayList<>();

        try {
            File myObj = new File(pathFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // add each line to my list
                listOfEachLineFromFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return listOfEachLineFromFile;
    }

    public static List<PersonWithDays> getListOfPeople(List<String> listOfEachLine) {
        List<PersonWithDays> personWithDaysList = new ArrayList<>();

        // iterate my list to print in console each line
        for (String line: listOfEachLine) {
            System.out.println(line);
            String[] splitNameAndDays = line.split("=");

            String name = splitNameAndDays[0];
            System.out.println(name); // name

            String[] daysAsArray = splitNameAndDays[1].split(",");
            System.out.println(daysAsArray); // days

            Map<String, TimeWorked> daysOfWorking = convertArrayDaysToMap(daysAsArray);

            PersonWithDays personWithDays = new PersonWithDays(name, daysOfWorking);

            personWithDaysList.add(personWithDays);
        }

        return personWithDaysList;
    }

    public static Map<String, TimeWorked> convertArrayDaysToMap (String[] days) {
        Map<String, TimeWorked> daysMap = new LinkedHashMap<>();

        for(String day: days) {
            String dayName = day.substring(0, 2);
            String[] times = day.substring(2).split("-");

            LocalTime startTime = LocalTime.parse(times[0]);
            LocalTime endTime = LocalTime.parse(times[1]);
            TimeWorked timeWorked = new TimeWorked(startTime, endTime);

            daysMap.put(dayName, timeWorked);
        }

        return daysMap;
    }

    public static void printListOfPeopleWithDays(List<PersonWithDays> personWithDaysList) {
        for (PersonWithDays personWithDays: personWithDaysList) {
            System.out.println(personWithDays.toString());
        }
    }
}
