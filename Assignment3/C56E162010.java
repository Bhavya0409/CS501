/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.uti.*;
public class C56E162010 {
public static void main(String[] args) {
    final int NUMBER_OF_PRIMES = 50; // Number of primes to display
    int[] primeArray = new int[50];
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness

    System.out.println("The first 50 prime numbers are \n");

    // Repeatedly find prime numbers
    while (count < NUMBER_OF_PRIMES) {
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
        for(int i = 0; i < primeArray.length; i++){
            System.out.print(primeArray[i] + " ");
        }
    }
}