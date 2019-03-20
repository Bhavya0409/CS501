/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 12 exercise 13
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
 public class C12E13File {
    private static int numLines = 0;
    private static int numCharacters = 0;
    private static int numWords = 0;
    private static boolean next = true;
    public static void main(String[] args) {
        System.out.println("This program asks to chose a .txt file and will output the number of lines, words, and characters");
        Scanner input = new Scanner(System.in);
        while(next){
            int numLines = 0;
            int numCharacters = 0;
            int numWords = 0;

            JFileChooser main = new JFileChooser(); //creates new filechooser
            main.setDialogTitle("Please Chose a .txt file"); //sets dialog title
            main.setFileFilter(new FileNameExtensionFilter("Open TXT file", "txt")); //sets the filter for selected files
            int returnVal = main.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION){ //if the approve button is hit it opens
                try {
                FileReader fr = new FileReader(main.getSelectedFile()); //creates new file reader
                BufferedReader br = new BufferedReader(fr); //bufffered reader reads file reader from selected file
                Scanner s = new Scanner(br); //scanner through input
                String nameOfFile = main.getSelectedFile().getName(); //sets name of file to the selected file

                for(int numLine = 1; s.hasNext(); numLine++){
                    String line = s.nextLine();
                    numLines++; //adds to line count
                    numCharacters = numCharacters + line.length(); //adds all character count to number of characters
                    String[] splitter = line.split("\\s+"); //splits the string via regex whitespaces
                    numWords = numWords + splitter.length; 
                }

                s.close();
                System.out.println(nameOfFile + " has: ");
                System.out.println(numCharacters + " characters");
                System.out.println(numWords + " words");
                System.out.println(numLines + " lines");
                } catch (Exception e) {
                    System.out.println("The file you are looking for cannot be found ");
                }
            }
            
            System.out.println("Would you like to open another file? Type 'no' to exit, or 'yes' to continue ");
            String toContinue = input.nextLine(); //loops to see if user wants to try another file out
            if (toContinue.equals("yes")) {  
                next = true;
            } else if(toContinue.equals("no")){
                next = false;
            } else {
                next = false;
            }
        }
        input.close();
        System.out.println("Program Exit");
    }
 }