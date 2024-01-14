import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = Files.newInputStream(file, StandardOpenOption.CREATE);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                System.out.printf("%-8s%-15s%-30s%-10s\n", "ID#", "Name", "Description", "Cost");
                System.out.println("==========================================================");

                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;

                    // Split the record into its components
                    String[] components = rec.split(", ");

                    // Format and print each component
                    System.out.printf("%06d\t%-15s%-30s%-10s\n", Integer.parseInt(components[0]), components[1], components[2], components[3]);
                }

                reader.close();
                System.out.println("\n\nData file read!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
