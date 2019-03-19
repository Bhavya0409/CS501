/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 6 exercise 18
 */
import java.util.*;
public class C6E18CheckPassword {

    private static boolean next = true;

    public static boolean validLength(String input){
        final int passwordLength = 10;
        return input.length() >= passwordLength; //checks password length
    }

    public static boolean onlyLettersAndDigits(String input) { //checks if only letters and digits
        for(int i = 0; i < input.length(); i++){
            if(Character.isLetterOrDigit(input.charAt(i)) == false){
                return false; //if the character at i position is not a valid letter or digit return false
            }
         }
         return true;
    }

    public static boolean checkDigits(String input){ //checks number of digits
        final int checkDigits = 3;
        int numberOfDigits = 0;
        for (int i = 0; i < input.length(); i++){  //loop through and get number of digits
            if(Character.isDigit(input.charAt(i))){
                numberOfDigits += 1;
            }
        }

        if(numberOfDigits < checkDigits){  //if number of digits is less than check digits return false
            return false;
        }
        return true;
    }

    public static void isPasswordValid(String input) throws Exception{ //tests all cases for a valid password
        if(!validLength(input)){
            throw new Exception("Invalid Password");
        } else if (!onlyLettersAndDigits(input)){
            throw new Exception("Invalid Password");
        } else if (!checkDigits(input)){
             throw new Exception("Invalid Password");
        }
    }


    public static void main(String[] args) {
        System.out.println("This program asks for a password and tests if it is valid or not");
        Scanner input = new Scanner(System.in);

        while (next) {
            System.out.print("Please enter a new password that has at least 10 characters, consists of only letters and digits, and contains at least three digits: ");
            String password = input.nextLine();

            try {
                isPasswordValid(password);  
                System.out.println("Valid Password");
            } catch (Exception e) {
                System.out.println(e.getMessage()); //If not valid throws the message
            }

            System.out.println("Would you like to try another password? Type 'no' to exit, or 'yes' to continue");
            String toContinue = input.nextLine(); 
            if (toContinue.equals("yes")) {   //test for users input to continue the loop
                next = true;
            } else if(toContinue.equals("no")){
                next = false;
            } else {
                next = false;
            }
        }

        System.out.println("Program exit.");
        input.close();
    }
}