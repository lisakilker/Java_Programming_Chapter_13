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
public class Waitstaff extends Employee {

    public double waitstaffPayRate = 10.00;

    public void setEmployeePayRate(double pay) {
        if (pay > waitstaffPayRate) {
            employeePayRate = waitstaffPayRate;
        } else {
            employeePayRate = pay;
        }
    }

    public void setEmployeeJobTitle() {
        employeeJobTitle = "Waitstaff";
    }
}
