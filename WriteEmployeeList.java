/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class WriteEmployeeList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String employeeData = "";
        String delimiter = ",";
        int employeeID;
        String employeeFirstName;
        String employeeLastName;
        final int QUIT = 0;

        Path file = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\WriteEmployeeList.txt");

        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter the employee ID: ");
            employeeID = userInput.nextInt();

            while (employeeID != QUIT) {
                System.out.print("Enter employee first name for employee " + employeeID + ": ");
                userInput.nextLine();
                employeeFirstName = userInput.nextLine();
                System.out.print("Enter employee last name for employee " + employeeID + ": ");
                employeeLastName = userInput.nextLine();
                
                employeeData = (employeeID + delimiter + employeeFirstName + delimiter + employeeLastName);
                writer.write(employeeData, 0, employeeData.length());
                writer.newLine();
                
                System.out.print("Enter next Employee ID or 0 to QUIT: ");
                employeeID = userInput.nextInt();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input/output error!");
        } catch (Exception e) {
            System.out.println("Exception thrown!");
        }
    }
}
