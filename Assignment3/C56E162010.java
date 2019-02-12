/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.*;
public class C56E162010 {
    public static int[] allPrimes(){
        int[] primeArray = new int[168]; //array to store all prime numbers less than 1000
        int count = 0; // Count the number of prime numbers
        int number = 2; // starting number for primeness test

        // Repeatedly find prime numbers
        while (count < primeArray.length) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test whether number is prime
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }  
            // Display the prime number and increase the count
            if (isPrime) {
                primeArray[count] = number;
                count++; // Increase the count

            }
            // Check if the next number is prime
            number++;
        }

        return primeArray;
    }

    public static boolean isPrime(int number) { //loops through prime array and tests if the number exists in there and is prime
        int[] primeNumbers = allPrimes();
        for(int i = 0; i < primeNumbers.length; i++){
            if (number == primeNumbers[i]) {
                return true;
            }
        }
        return false; // Number is not prime
    }

    public static String factors(int number){
        String allFactors = "";
        for(int i = 2; i <= number; i++){
            while (number % i == 0){
                allFactors = allFactors + " " + i;
                number = number / i;
            }
        }
        return allFactors;
    }

    public static void main(String[] args) {
        int[] testArray = allPrimes();
        Scanner input = new Scanner(System.in);
        boolean next = true;

        System.out.println("The first 50 prime numbers are \n");
        for(int i = 0; i < 50; i++){
            if((i + 1) % 10 == 0) {
                System.out.println(testArray[i] + " ");
            } else {
                System.out.print(testArray[i] + " ");
            }
        }

        while (next == true) {
            System.out.println("Please enter a whole number less than 1000 to test for primeness: ");
            int numberToTest = input.nextInt();
            boolean primeNumber = isPrime(numberToTest);
            if (primeNumber == true) {
                System.out.println("The number: " + numberToTest + " IS prime");
            } else {
                System.out.println("The number: " + numberToTest + " is NOT prime but its factors are: " + factors(numberToTest));
                
            }

            System.out.println("Would you like to test for another number? Type 'no' to exit, or 'yes' to continue ");
            String toContinue = input.next(); 
            if (toContinue.equals("yes")) {   //test for users input to continue the loop
                next = true;
            } else if(toContinue.equals("no")){
                next = false;
            } else {
                next = false;
            }
        
        }
        input.close();
        
    }

}