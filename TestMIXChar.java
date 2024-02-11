package q3;

import java.util.Scanner;

/**
 * <p>The TestMIXChar class uses the methods of the MIXChar class.
 * and the Message class to determine if a user input of strings.
 * or characters are MIXCHar characters. If any character entered.
 * is not a MIXChar character, the program will throw and illegal.
 * argument exception. Otherwise, the program will encode the.
 * the given characters into unsigned long values of base 56,. 
 * then decode them into back into strings.</p>  
 *
 * @author Billy Wei
 * @version fall23
 */
public class TestMIXChar {
    
    //the following are for reference, you may want to move them or copy them 
    //to another class.
    
    /** The instance variable for Greek symbol delta. */
    private static final char DELTA = '\u0394';
    
    /** The instance variable for Greek symbol sigma. */
    private static final char SIGMA = '\u03A3';
    
    /** The instance variable for Greek symbol PI. */
    private static final char PI = '\u03A0';
    
    
    
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //replace next line with your code:
   
        System.out.println("Please enter a some MIXChar Characters: ");
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        
        Message newMessage0 = new Message(input);
        
        String finalMessage = newMessage0.toString();
        String finalLongs = newMessage0.toLongs();
        
        System.out.println(finalLongs);
        System.out.println(finalMessage);

        System.out.println();
        System.out.println("Question three was called and ran sucessfully.");
        scan.close();
    }
    
}
