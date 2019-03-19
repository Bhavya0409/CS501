/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 6 exercise 23
 */
import java.util.*;
public class C6E23Occurance {

    private static boolean firstLoop = true;

    public static void validString(String str) throws Exception{ //Only want to allow a string with letters and numbers
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetterOrDigit(str.charAt(i)) == false){
                throw new Exception("String provided can only include numbers and letters"); //if the character at i position is not a valid letter or digit return false
            }
        }
    }

    public static int count(String str, char a) throws Exception{
        int numberOfOccurences = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == a){
                numberOfOccurences++;
            }
        }
        return numberOfOccurences;
    }

    public static void main(String[] args) {
        System.out.println("This program takes a string and a character and determines how many times the characters occurs in the string");
        Scanner input = new Scanner(System.in);
        while(firstLoop){
            System.out.print("Please enter a string that includes only letters and numbers: ");
            String mainString = input.nextLine();
            boolean secondLoop = true;
            try {
                validString(mainString); //tests a strings validity
                while(secondLoop){
                    System.out.print("Please enter a character to test occurence: "); 
                    char character = input.nextLine().charAt(0); //gets the character to test from input
                    System.out.println("The number of occurances for character " + "'" + character + "'" + " in " + "'"+ mainString + "'" + " is: " + count(mainString,character));
                    System.out.println("Would you like to test another characters occurance? Type 'no' to exit, or 'yes' to continue ");
				    String toContinue = input.nextLine(); //loops to see if user wants to test another characters occurance
				    if (toContinue.equals("yes")) {  
						secondLoop = true;
				    } else if(toContinue.equals("no")){
						secondLoop = false;
				    } else {
						secondLoop = false;
				    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Would you like to input another string? Type 'no' to exit, or 'yes' to continue ");
            String continueMain = input.nextLine(); //loops to see if user wants to test another string or exit
            if (continueMain.equals("yes")) {  
                firstLoop = true;
            } else if(continueMain.equals("no")){
                firstLoop = false;
            } else {
                firstLoop = false;
            }
        }
        System.out.println("Program exit.");
        input.close();
    }
}