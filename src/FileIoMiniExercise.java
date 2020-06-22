import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIoMiniExercise {
    public static void main(String[] args) throws IOException {

        // TODO: define the path to the instructor-names.txt file
        Path instructorNames = Paths.get("src", "instructor-names.txt");

        // TODO: uncomment the following variable declarations
        List<Instructor> instructors;
        List<String> names = new ArrayList<>();

        // TODO: read the contents of the instructor-names.txt file and store the list of strings into the 'names' variable
        names = Files.readAllLines(instructorNames);
        System.out.println(names);
        // TODO: assign the 'instructors' variable a list of Instructor objects with names matching the list of strings/names from the text file (the Instructor class has a helpful method for this)
        instructors = Instructor.nameStringsToInstructors(names);

        // TODO: greet all instructors by their names
//        for(Instructor instructor : instructors) {
//            System.out.println("Hello, " + instructor.getName() + "!");
//        }
        greetInstructors(instructors);
        // TODO: change "Fred" to "David" in the list of Instructor objects
        List<Instructor> newInstructors = new ArrayList<>();
        for(Instructor instructor : instructors) {
            if (instructor.getName().equals("Fred")) {
                instructor.setName("David");
            }
            newInstructors.add(instructor);
        }

        // TODO: update the list of strings/names ('names' variable) to the latest names from the Instructor objects (the Instructor class has a helpful method for this)
        names = Instructor.instructorsToNameStrings(newInstructors);
        System.out.println(names);

        // TODO: overwrite the instructors-names.txt file with the latest list of names
        Files.write(instructorNames, names);
        // TODO: uncomment the following line
        System.out.println("============== after name change...");

        // TODO: greet instructors again (no need to reread the text file again; just use the existing list of instructors in memory)
        greetInstructors(newInstructors);

    }

    /**
     * This method takes in a list of Instructor objects and prints out "Hello, NAME!" for each Instructor object's name
     * @param instructors is a list of Instructor objects
     */
    public static void greetInstructors(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            System.out.printf("Hello, %s!%n", instructor.getName());
        }
    }

    /**
     * This method takes in a list of Instructor objects and changes the name of the Instructor with a name of "Fred" to "David"
     * @param instructors is a list of Instructor objects
     */
    public static void changeFredToDavid(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equals("Fred")) {
                instructor.setName("David");
            }
        }
    }

}
