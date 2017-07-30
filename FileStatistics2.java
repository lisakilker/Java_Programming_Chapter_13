/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

/**
 *
 * @author Lisa
 */
public class FileStatistics2  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Path file1 = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\Quote.txt");
        Path file2 = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\Quote.docx");

        try {
            BasicFileAttributes attr1 = Files.readAttributes(file1, BasicFileAttributes.class);
            System.out.println("File 1 size = " + attr1.size());
        } catch (Exception e) {
            System.out.println("File 1 cannot be found.");
        }

        try {
            BasicFileAttributes attr2 = Files.readAttributes(file2, BasicFileAttributes.class);
            System.out.println("File 2 size = " + attr2.size());
        } catch (Exception e) {
            System.out.println("File 2 cannot be found.");
        }

        if (Files.size(file1) != Files.size(file2)) {
            System.out.println("The files are not the same size.");
            System.out.println("The ratio to " + file1.getFileName() + " is: " + (Files.size(file1) / Files.size(file2)));
            System.out.println("The ratio to " + file2.getFileName() + " is: " + (Files.size(file2) / Files.size(file1)));

        } else {
            System.out.println("The file are the same size.");
        }
    }
}
