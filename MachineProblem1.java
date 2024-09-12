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


// create a class called calculator
public class Calculator {

    private String name;

    public Float addition(Float A, Float B){
        return A + B;
    }
    public Float subtraction(Float A, Float B){
        return A - B;
    }
    public Float multiplication(Float A, Float B){
        return A * B;
    }
    public void setname(String N){
        return N;
    }
    public String getname(){

    }
}

public class void main(String[] args) {
    setname("Group 35");
    System.out.println("Welcome to the Calculator designed by \"" + mycalc.getName() + "\".");

    while (true) {
        System.out.println("Enter A to Add, S to Subtract, M to Multiply, and Q to quit.");
        String command = scanner.nextLine().toUpperCase();
        
        if (command.equals("Q")) {
            System.out.println("Goodbye!");
            break;
        }

        if (command.equals("A") || command.equals("S") || command.equals("M")) {
            System.out.print("Enter argument 1: ");
            Float arg1 = Float.parseFloat(scanner.nextLine());
            
            System.out.print("Enter argument 2: ");
            Float arg2 = Float.parseFloat(scanner.nextLine());

            Float result = null;
            switch (command) {
                case "A":
                    result = mycalc.addition(arg1, arg2);
                    System.out.println("The sum of " + arg1 + " and " + arg2 + " is " + result);
                    break;
                case "S":
                    result = mycalc.subtraction(arg1, arg2);
                    System.out.println("The difference of " + arg1 + " and " + arg2 + " is " + result);
                    break;
                case "M":
                    result = mycalc.multiplication(arg1, arg2);
                    System.out.println("The product of " + arg1 + " and " + arg2 + " is " + result);
                    break;
            }
        } else {
            // Invalid command, display welcome message again
            System.out.println("Invalid input. Please try again.");
        }
    }

}


public class void main(String[] args) {
    setname("Group 35");

}
