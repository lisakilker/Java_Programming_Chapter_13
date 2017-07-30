/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class DisplaySelectedIDNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String employeeData = "";
        String employeeID;
        boolean exists = true;

        Path file = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\WriteEmployeeList.txt");

        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter employee ID number: ");
            employeeID = userInput.next();
            employeeData = reader.readLine();

            do {
                if (employeeData.startsWith(employeeID)) {
                    System.out.println(employeeData);
                    exists = true;
                    break;
                } else {
                    exists = false;
                    employeeData = reader.readLine();
                }
            } while (!exists && employeeData != null);

            reader.close();

            if (!exists) {
                System.out.println("That employee does not exist!");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input/output error!");
        } catch (Exception e) {
            System.out.println("Exception thrown!");
        }
    }
}
