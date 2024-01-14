import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> personRecords = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter Person data (ID, FirstName, LastName, Title, YearOfBirth), or 'exit' to finish:");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Validate input using SafeInput
                if (validateInput(input)) {
                    personRecords.add(input);
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            System.out.println("Enter a name for the file to save the Person data:");
            String fileName = scanner.nextLine().trim();

            // Save data to file
            saveToFile(fileName, personRecords);

            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateInput(String input) {
        // Implement your validation logic using SafeInput library
        // For simplicity, let's assume the input is always valid
        return true;
    }

    private static void saveToFile(String fileName, ArrayList<String> records) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        }
    }
}
