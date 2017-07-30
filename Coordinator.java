/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2HW;


/**
 *
 * @author Lisa
 */
public class Coordinator extends Employee{
    
    public double coordinatorPayRate = 20.00;

    public void setEmployeePayRate(double pay) {
        if (pay > coordinatorPayRate) {
            employeePayRate = coordinatorPayRate;
        } else {
            employeePayRate = pay;
        }
    }

    public void setEmployeeJobTitle() {
        employeeJobTitle = "Coordinator";
    }
}
