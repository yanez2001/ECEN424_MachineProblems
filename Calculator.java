/* Yanez Saucedo, Evan Tsoi
 * Machine Problem #1 - ECEN 424
 * Group 35
 * Texas A&M University - Fall 2024
 * 
 * 
 * 
 * Implement a calculator that performs the operations of addition,
 * subtraction and multiplication.
 * 
 */

import java.util.Scanner; 

// create a class called calculator
public class Calculator {

    private String name;

    // addition method
    public Float addition(Float A, Float B){
        return A + B;
    }
    // subtraction method
    public Float subtraction(Float A, Float B){
        return A - B;
    }
    //multiplication method
    public Float multiplication(Float A, Float B){
        return A * B;
    }
    // setname method (this is used to actually set the name)
    public void setname(String N){
        this.name = N;
    }
    // getname method (this is used to get a name)
    public String getname(){
        return this.name;
    }

    // Main method of calculator
    public static void main(String[] args) {
        // Initialization of scanner and calculator
        Scanner scanner = new Scanner(System.in);
        // a new Calculator object called mycalc must be created.
        Calculator mycalc = new Calculator();
        // call the setname to set your group number (we're 35)
        mycalc.setname("Group 35");
        // system printing out the line using getname method
        System.out.println("Welcome to the Calculator designed by \"" + mycalc.getname() + "\".");
    
        // whole code is in a while loop
        while (true) {
            // ask user which method to use
            System.out.println("Enter A to Add, S to Subtract, M to Multiply, and Q to quit.");
            // this scans the next line of terminal (input), and sets it as the command and changes it to uppercase if needed
            String command = scanner.nextLine().toUpperCase();
            
            // if Q is entered, quit the calculator
            if (command.equals("Q")) {
                System.out.println("Goodbye!");
                // break out of the loop
                break;
            }
            
            // set the method and parse the inputs/args as a string
            if (command.equals("A") || command.equals("S") || command.equals("M")) {
                System.out.print("Enter argument 1: ");
                // parse arg1 as a string
                Float arg1 = Float.parseFloat(scanner.nextLine());
                
                System.out.print("Enter argument 2: ");
                // parse arg2 as a string
                Float arg2 = Float.parseFloat(scanner.nextLine());
    
                // initialize the result to null (empty)
                Float result = null;
                // use case switches to determine which method to do
                switch (command) {
                    case "A":
                        // the result uses the addition method
                        result = mycalc.addition(arg1, arg2);
                        System.out.println("The sum of " + arg1 + " and " + arg2 + " is " + result);
                        break;
                    case "S":
                        // the results uses the subtraction method
                        result = mycalc.subtraction(arg1, arg2);
                        System.out.println("The difference of " + arg1 + " and " + arg2 + " is " + result);
                        break;
                    case "M":
                        // the results uses the multiplication method
                        result = mycalc.multiplication(arg1, arg2);
                        System.out.println("The product of " + arg1 + " and " + arg2 + " is " + result);
                        break;
                }
            } else {
                // Invalid command, display welcome message again
                System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}
