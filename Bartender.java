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
public class Bartender extends Employee {

    public double bartenderPayRate = 14.00;

    public void setEmployeePayRate(double pay) {
        if (pay > bartenderPayRate) {
            employeePayRate = bartenderPayRate;
        } else {
            employeePayRate = pay;
        }
    }

    public void setEmployeeJobTitle() {
        employeeJobTitle = "Bartender";
    }
}
