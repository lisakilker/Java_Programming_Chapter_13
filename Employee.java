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
public abstract class Employee {

    private String employeeID;
    private String employeeFirstName;
    private String employeeLastName;
    protected double employeePayRate;
    protected String employeeJobTitle;

    public String getEmployeeID() {
        return employeeID;
    }
    
    public void setEmployeeID(String employeeID){
        this.employeeID = employeeID;
    }
    
    public String getEmployeeFirstName(){
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    
    public String getEmployeeJobTitle(){
        return employeeJobTitle;
    }
    
    public double getEmployeePayRate(){
        return employeePayRate;
    }

    public abstract void setEmployeePayRate(double pay);
    public abstract void setEmployeeJobTitle();
}
