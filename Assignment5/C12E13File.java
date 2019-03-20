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
    private static String nameOfFile = "";
    public static void main(String[] args) {
        System.out.println("This program asks to chose a .txt file and will output the number of lines, words, and characters");
        JFileChooser main = new JFileChooser();
        main.setDialogTitle("Please Chose a .txt file");
        main.setFileFilter(new FileNameExtensionFilter("Open TXT file", "txt"));
        int returnVal = main.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try {
            FileReader fr = new FileReader(main.getSelectedFile());
            BufferedReader br = new BufferedReader(fr);
            Scanner s = new Scanner(br);
            nameOfFile = main.getSelectedFile().getName();
            for(int numLine = 1; s.hasNext(); numLine++){
                String line = s.nextLine();
                numLines++; //adds to line count
                numCharacters = numCharacters + line.length(); //adds all character count to number of characters
                String[] splitter = line.split("\\s+");
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
    }
 }