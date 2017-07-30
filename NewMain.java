/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String employeeFirstName;
        boolean exists = true;
        String employeeData = "";
        
        Path file = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\WriteEmployeeList.txt");

        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter employee ID number: ");
            employeeFirstName = userInput.next();
            employeeData = reader.readLine();

            do {
                if (employeeData.startsWith(employeeFirstName)) {
                    System.out.println(employeeData);
                    employeeData = reader.readLine();
                    exists = true;
                    //break;
                } else {
                    exists = false;
                    employeeData = reader.readLine();
                }
            } while (!exists && employeeData != null);

            reader.close();

            if (!exists) {
                System.out.println("That employee does not exist!");
            }
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}

    
