/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;

import java.nio.file.*;

/**
 *
 * @author Lisa
 */
public class SameFolder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count1;
        int count2;
        boolean sameFolder;

        Path path1 = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\SameFolderTest1.txt");
        Path path2 = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\SameFolderTest2.txt");

        count1 = path1.getNameCount();
        count2 = path2.getNameCount();

        sameFolder = false;
        if (count1 == count2) {

            for (int i = 0; i < count1 - 1; i++) {
                if (path1.getName(i).compareTo(path2.getName(i)) == 0) {
                    sameFolder = true;
                }

            }
            if (sameFolder) {
                System.out.println("The files are in the same folder.");
            }

        } else {
            System.out.println("The files are not in the same folder.");
        }
    }
}
