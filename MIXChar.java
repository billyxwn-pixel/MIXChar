package q3;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The MIXChar Class defines the instances of a MIXChar.
 * character adapted from the table of 56 set of.
 * characters of for the MIX computer.</p>
 * 
 * @author Billy Wei
 * @version fall23
 */
public class MIXChar {
    /** Instance variable for a list of MIXChar characters. */
    private static List<Character> mixCharSet;
    
    /** 
     * The instance variable for the value of.
     * a MIXChar object. 
     */
    private int value;
    
    /** The instance variable for the character of.
     * a MIXChar object. */
    private char mixChar;
    
    /**
     * MIXChar is the constructor for a MIXChar object.
     * which is defined by the MIXChar class. It takes.
     * a character (char) and determines if the character.
     * matches any of the MIXChar characters in the MIXChar.
     * character list (createMIXCharList static method).
     * If it does exist, it creates the MIXChar object with.
     * the given character and the index (integer) of the.
     * MIXChar character that is in the MIXChar list. 
     * @param c is a character.
     */
    public MIXChar(char c) {
        List<Character> mixCharList = createMIXCharList();
        boolean found = false;
        for (char eachChar : mixCharList) {
            if (eachChar == c) {
                mixChar = c;
                value = mixCharList.indexOf(eachChar); 
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Character " 
                    + "\"" + c + "\"" + " is not a " 
                    + "MIXChar character!");
        }
    }
    
    /**
     * No parameter constructor for MIXChar. For.
     * debugging purposes/checking to see if the.
     * ArrayList of MIXChars was successfully produced.
     * It assigns the instance variable to the.
     * created MIXChar ArrayList. 
     */
    public MIXChar() {
        mixCharSet = createMIXCharList(); 
    }
    
    /**
     * The getter for the MIXChar Array List that.
     * holds the MIXChar characters. Also for testing.
     * and debugging purposes. 
     * @return mixCharSet as an array list. 
     */
    public List<Character> getMIXCharList() {
        return mixCharSet;
    }
    
    /**
     * The createMIXCharList method adds all the characters.
     * and symbols of the MIXChar table in their respective.
     * order on the table to an ArrayList called mixCharSet.
     * The indexes matches the corresponding values of each.
     * character in the MIXChar table. 
     * @return mixCharSet as an ArrayList of characters. 
     */
    public static List<Character> createMIXCharList() {
        // Constant for 56
        final int fiftySix = 56;
        
        mixCharSet = new ArrayList<Character>(fiftySix);
        
        // First, add a space to the ArrayList (' ')
        mixCharSet.add(' ');
        
        // Add characters A - I
        for (char c = 'A'; c <= 'I'; c++) {
            mixCharSet.add(c);
        }
        // Then add Δ at index 10 of mixCharSet list
        mixCharSet.add('\u0394');
        
        // Add characters J to R
        for (char c = 'J'; c <= 'R'; c++) {
            mixCharSet.add(c);
        }
        
        // Add characters Σ and Π at indices 20 and 21.
        // respectively. 
        // index 20
        mixCharSet.add('\u03A3');
        // index 21
        mixCharSet.add('\u03A0');
        
        // Add characters S to Z
        for (char c = 'S'; c <= 'Z'; c++) {
            mixCharSet.add(c);
        }
        
        // Add digits 0 to 9 as characters
        for (char c = '0'; c <= '9'; c++) {
            mixCharSet.add(c);
        }
        
        // Add symbols.
        char[] symbols = {'.', ',', '(', ')', '+',
            '-', '*', '/', '=', '$', '<',
            '>', '@', ';', ':', '\''};
        for (char c : symbols) {
            mixCharSet.add(c); 
        }
        
        return mixCharSet; 
    }
    
    /**
     * isMIXChar is the method that determines if a given.
     * character c matches any of the characters in the.
     * MIXChar list. Returns true if it does, else returns.
     * false.
     * @param c is a character.
     * @return boolean as either true or false. 
     */
    public static boolean isMIXChar(char c) {
        List<Character> mixCharList = createMIXCharList();
        for (char eachChar : mixCharList) {
            if (eachChar == c) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * The toChar method takes the MIXChar object and converts.
     * it back into a Character using its value (integer). 
     * @return the character stored a index of the MIXChar list.
     *         indicated by the value of the MIXChar object.
     */
    public char toChar() {
        List<Character> mixCharSet = createMIXCharList();
        return mixCharSet.get(value);
    }
    
    /**
     * The ordinal method returns the value of the MIXChar.
     * object. 
     * @return value as an integer.
     */
    public int ordinal() {
        return value; 
    }
    
    /**
     * The toString method takes the mixChar attribute.
     * of a MIXChar object and returns it as a string type.
     * @return mixChar as a string type. 
     */
    public String toString() {
        return mixChar + "";
    }
    
    /**
     * The toString(MIXChar[]) takes an array of.
     * characters and returns them as one string.
     * @param mixChar is an array of MIXChar objects.
     * @return result as a string of MIXChar characters.
     */
    public String toString(MIXChar[] mixChar) {
        StringBuilder result = new StringBuilder();
        for (MIXChar eachChar : mixChar) {
            result.append(eachChar.toString());
        }
        return result.toString();
    }
    
    /**
     * The toMIXChar(String s) method takes a string.
     * and builds a MIXChar object from each character.
     * of the string. If there are any characters in.
     * the string that are not a MIXChar, then an.
     * IllegalArgumentException is thrown.
     * @param s is a string type. 
     * @return listOfMixChar as an array that contains a.
     *         reference to the MIXChar objects.
     */
    public static MIXChar[] toMIXChar(String s) {
        List<Character> mixCharList = createMIXCharList();
        MIXChar[] listOfMixChar = new MIXChar[s.length()];
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            for (char eachChar : mixCharList) {
                if (character == eachChar) {
                    MIXChar mixCharObj = new MIXChar(character);
                    listOfMixChar[i] = mixCharObj; 
                    found = true;
                    break;
                } 
            }
            if (!found) {
                throw new IllegalArgumentException("Character " 
                        + character + " is not a MIXChar " 
                        + "character!");
            }
        }
        return listOfMixChar; 
    }
    

}
