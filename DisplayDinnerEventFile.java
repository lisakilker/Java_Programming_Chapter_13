/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Lisa
 */
public class DisplayDinnerEventFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\StaffDinnerFile.txt");
        
        try {
            InputStream input = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String text = reader.readLine();

            while (text != null) {
                System.out.println(text);
                text = reader.readLine();
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input/output error!");
        } catch (Exception e) {
            System.out.println("Exception thrown!");
        }
    }
}
