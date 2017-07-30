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
public abstract class StaffDinnerEventAndCreateFile extends Employee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String eventNum;
        int guests, entree, side1, side2, dessert, waiters, bartenders, coordinators, count;
        Employee[] employee = new Employee[15];

        DinnerEvent[] dinnerEvents = new DinnerEvent[3];

        for (int x = 0; x < dinnerEvents.length; ++x) {
            System.out.println("***NEW EVENT***");
            eventNum = getEventNumber();
            guests = getGuests();
            entree = getEntree();
            side1 = getSides();
            side2 = getSides();
            dessert = getDessert();

            dinnerEvents[x] = new DinnerEvent(eventNum, guests, entree, side1, side2, dessert);
            dinnerEvents[x].setContactPhoneNumber(getContactPhone());
            dinnerEvents[x].setEventType(getEventType());

            waiters = guests / 10 + 1;
            for (count = 0; count < waiters; count++) {
                employee[count] = getWaitstaff();
            }

            bartenders = guests / 25 + 1;
            for (; count < waiters + bartenders; count++) {
                employee[count] = getBartender();
            }

            coordinators = guests / guests;
            for (; count < waiters + bartenders + coordinators; count++) {
                employee[count] = getCoordinator();
            }

            dinnerEvents[x].setEmployee(employee);
            displayEventDetails(dinnerEvents[x], count);
            
        }
        writeToFile(dinnerEvents);
    }

    public static String getEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the event number: ");
        num = input.nextLine();
        return num;
    }

    public static int getGuests() {
        int guests = -1;

        while (guests < 0) {

            try {
                Scanner input = new Scanner(System.in);

                do {
                    System.out.print("Enter the amount of guests: ");
                    guests = input.nextInt();
                    input.nextLine();
                } while (guests < 5 || guests > 100);

            } catch (Exception e) {
                System.out.println("ERROR!  That is not a valid number!");
            }
        }
        return guests;
    }

    public static String getContactPhone() {
        String phone = "000000000";

        while (phone.length() != 10) {
            Scanner input = new Scanner(System.in);
            System.out.print("What is your phone number? ");
            phone = input.nextLine();
        }
        return phone;
    }

    public static int getEventType() {

        int num = -1;

        while (num < 0 || num > 4) {

            try {
                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("The event types are: ");
                for (int x = 0; x < Event.EVENT_TYPE_NAMES.length; ++x) {
                    System.out.println("    " + x + " " + Event.EVENT_TYPE_NAMES[x]);
                }
                System.out.print("What is your event type? ");

                num = input.nextInt();
                if (num < 0 || num > 4) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("ERROR! That number is not valid!");
            }
        }
        return num;
    }

    public static int getEntree() {
        int num = -1;

        while (num < 0 || num > 2) {

            try {

                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("Entree choices are: ");
                for (int j = 0; j < DinnerEvent.ENTREES.length; ++j) {
                    System.out.println("    " + j + " " + DinnerEvent.ENTREES[j]);
                }
                System.out.print("What number entree would you like? ");

                num = input.nextInt();
                if (num < 0 || num > 2) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("ERROR! That number is not valid!");
            }
        }
        return num;
    }

    public static int getSides() {
        int num = -1;

        while (num < 0 || num > 2) {

            try {
                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("Side dish choices are: ");
                for (int j = 0; j < DinnerEvent.SIDE_DISHES.length; ++j) {
                    System.out.println("    " + j + " " + DinnerEvent.SIDE_DISHES[j]);
                }
                System.out.print("What number entree would you like? ");

                num = input.nextInt();
                if (num < 0 || num > 2) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("ERROR! That number is not valid!");
            }
        }
        return num;
    }

    public static int getDessert() {
        int num = -1;

        while (num < 0 || num > 2) {

            try {
                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("Dessert choices are: ");
                for (int j = 0; j < DinnerEvent.DESSERTS.length; ++j) {
                    System.out.println("    " + j + " " + DinnerEvent.DESSERTS[j]);
                }
                System.out.print("What number entree would you like? ");

                num = input.nextInt();
                if (num < 0 || num > 2) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("ERROR! That number is not valid!");
            }
        }
        return num;
    }

    public static Waitstaff getWaitstaff() {
        Waitstaff waitstaff = new Waitstaff();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter waitstaff employee ID number: ");
        waitstaff.setEmployeeID(input.nextLine());
        System.out.println("Enter waitstaff employee first name: ");
        waitstaff.setEmployeeFirstName(input.nextLine());
        System.out.println("Enter waitstaff employee last name: ");
        waitstaff.setEmployeeLastName(input.nextLine());

        boolean isValidPayRate = false;
        while (!isValidPayRate) {
            isValidPayRate = true;
            try {
                System.out.println("Enter waiter hourly pay rate: ");
                waitstaff.setEmployeePayRate(input.nextDouble());

            } catch (Exception e) {
                System.out.println("ERROR!  That is not a valid pay rate!");
                isValidPayRate = false;
            }
            input.nextLine();
            waitstaff.setEmployeeJobTitle();
        }
        return waitstaff;
    }

    public static Bartender getBartender() {
        Bartender bartender = new Bartender();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bartender employee ID number: ");
        bartender.setEmployeeID(input.nextLine());
        System.out.println("Enter bartender employee first name: ");
        bartender.setEmployeeFirstName(input.nextLine());
        System.out.println("Enter bartender employee last name: ");
        bartender.setEmployeeLastName(input.nextLine());

        boolean isValidPayRate = false;
        while (!isValidPayRate) {
            isValidPayRate = true;
            try {
                System.out.println("Enter bartender hourly pay rate: ");
                bartender.setEmployeePayRate(input.nextDouble());

            } catch (Exception e) {
                System.out.println("ERROR!  That is not a valid pay rate!");
                isValidPayRate = false;
            }
            input.nextLine();
            bartender.setEmployeeJobTitle();
        }
        return bartender;
    }

    public static Coordinator getCoordinator() {
        Coordinator coordinator = new Coordinator();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinator employee ID number: ");
        coordinator.setEmployeeID(input.nextLine());
        System.out.println("Enter coordinator employee first name: ");
        coordinator.setEmployeeFirstName(input.nextLine());
        System.out.println("Enter coordinator employee last name: ");
        coordinator.setEmployeeLastName(input.nextLine());

        boolean isValidPayRate = false;
        while (!isValidPayRate) {
            isValidPayRate = true;
            try {
                System.out.println("Enter coordinator hourly pay rate: ");
                coordinator.setEmployeePayRate(input.nextDouble());

            } catch (Exception e) {
                System.out.println("ERROR!  That is not a valid pay rate!");
                isValidPayRate = false;
            }
            input.nextLine();
            coordinator.setEmployeeJobTitle();
        }
        return coordinator;
    }

    public static void writeToFile(DinnerEvent[] dinnerEvents) {
        String dinnerEventData;
        String delimiter = ",";

        Path file = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W2HW\\StaffDinnerFile.txt");

        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            for (int x = 0; x < dinnerEvents.length; x++) {
                dinnerEventData = dinnerEvents[x].getEventNumber() + delimiter + dinnerEvents[x].getNumberOfGuests() + delimiter + dinnerEvents[x].getEventType() + delimiter + dinnerEvents[x].getPrice() + System.getProperty("line.separator");
                writer.write(dinnerEventData, 0, dinnerEventData.length());
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

    public static void displayEventDetails(DinnerEvent dinnerEvents, int count) {
        Employee[] employee = new Employee[15];
        employee = dinnerEvents.getEmployee();
        System.out.println();
        System.out.println("--EVENT DETAILS--");
        System.out.println("Event number is: " + dinnerEvents.getEventNumber());
        System.out.println("Number of guests is: " + dinnerEvents.getNumberOfGuests());
        System.out.println("Phone number is:  " + dinnerEvents.getContactPhone());
        System.out.println("Event type number is: " + dinnerEvents.getEventType() + ". The event type is: " + dinnerEvents.getEventName(dinnerEvents.getEventType()));
        System.out.println("Is this a large event? " + dinnerEvents.isLargeEvent() + "." + " The price per guest is $" + dinnerEvents.getPricePerGuest() + ". The total cost is: $" + dinnerEvents.getPrice());
        System.out.println(dinnerEvents.getMenu());
        for (int i = 0; i < count; i++) {
            System.out.println("**Staff includes** " + "Employee ID: " + employee[i].getEmployeeID() + ", Name: "
                    + employee[i].getEmployeeFirstName() + " " + employee[i].getEmployeeLastName() + ", Hourly pay: "
                    + employee[i].getEmployeePayRate() + ", Title: " + employee[i].getEmployeeJobTitle());
        }
    }
}
