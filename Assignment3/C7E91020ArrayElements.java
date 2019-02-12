/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.*;
import java.util.Arrays;
public class C7E91020ArrayElements {
	public static double max(double[] array){
		double maxNumber = array[0];
		for(int i = 1; i < array.length; i++ ){
			if (array[i] > maxNumber){
				maxNumber = array[i];
			}
		}
		return maxNumber;
	}
	public static int indexOfLargestElement(double[] array){
		int indexLargestElement = 0;
		double largestNumber = max(array);
		for(int i = 0; i < array.length; i++){
			if (array[i] == largestNumber){
				indexLargestElement = i;
				break;
			}
		}
		return indexLargestElement;
	}

    public static void main(String[] args){
        System.out.println("This program will search for the maximum value and index of an array, and sort it in ascending order.");
        Scanner input = new Scanner(System.in);
			while (true) {
				System.out.println("Please enter 10 numbers, separated by spaces. You can quit the program at any time by having -1 as your first number.");
				double first = input.nextDouble();
				if (first == -1.0) {
					break;
				}
				double[] numbers = new double[10];
				numbers[0] = first;
				for (int i = 1; i < 10; i++) {
					numbers[i] = input.nextDouble();
				}
				System.out.println("Your numbers are: " + Arrays.toString(numbers));
				System.out.println("Your maximum number is " + max(numbers) + " and its index is: " + indexOfLargestElement(numbers));
			}
			System.out.println("Program exit.");
		input.close();
    }
}
