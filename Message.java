package q3;

import java.util.List;

/**
 * <p>The Message Class defines the attributes of a Message.
 * object. It has instances of message (long[]) and a.
 * count (integer).</p>
 * 
 * @author Billy Wei
 * @version Fall23
 */

public class Message {
    
    /** The instance variable message which represents.
     *  an array of long data types in a Message.
     *  object. */
    private long[] message;
    
    /** The instance variable for count, which represents.
     *  the number of character objects in a message object.*/
    private int count;
    
    /** 
     * Message(MIXChar[] m) is a constructor for the message class.
     * It takes an array of MIXChar objects.
     * @param m is an array of MIXChar objects. 
     */
    public Message(MIXChar[] m) {
        final double eleven = 11.0; 
        final int eleven0 = 11; 
        // Determining the number of long elements to.
        // be stored from the length of MIXChar array m.
        int numberOfSums = (int) Math.ceil(m.length / eleven); 
        
        // Set length of instance array of longs.
        message = new long[numberOfSums];
        
        // Loop through the instance array and calculate sums
        // of the base 56 converted products.
        for (int i = 0; i < numberOfSums; i++) {
            long sum = 0;
            int powers = 0;

            // Add every eleven elements after base 56 conversion.
            for (int j = 0; j < eleven; j++) {
                int index = (int) (i * eleven + j);

                if (index < m.length) {
                    final int base = 56;
                    int mixCharVal = m[index].ordinal();

                    sum += Long.parseUnsignedLong(Long.toUnsignedString(
                        mixCharVal * (long) Math.pow(base, powers)));

                    powers++;
                    count++;
                }
            }

            powers = 0;          
            message[i] = sum;
        }
        
    }
    
    /** 
     * Message(String s) is a constructor for the message class.
     * It takes a string.
     * @param s is a string. 
     */
    public Message(String s) {
        MIXChar[] mixCharObjList = MIXChar.toMIXChar(s);
        
        final double eleven = 11.0; 
        final int eleven0 = 11; 
        // Determining the number of long elements to.
        // be stored from the length of string s.
        int numberOfSums = (int) Math.ceil(s.length() / eleven); 
        
        // Set length of instance array of longs.
        message = new long[numberOfSums];
        
        // Loop through the instance array and calculate sums
        // of the base 56 converted products.
        for (int i = 0; i < numberOfSums; i++) {
            long sum = 0;
            int powers = 0;

            // Add every eleven elements after base 56 conversion.
            for (int j = 0; j < eleven; j++) {
                int index = (int) (i * eleven + j);

                if (index < s.length()) {
                    final int base = 56;
                    int mixCharVal = mixCharObjList[index].ordinal();

                    sum += Long.parseUnsignedLong(Long.toUnsignedString(
                        mixCharVal * (long) Math.pow(base, powers)));

                    powers++;
                    count++;
                }
            }

            powers = 0;          
            message[i] = sum;
        }  
    }
    
    /**
     * The toString method uses the instance array.
     * of the Message object and for each element within.
     * the instance array (a long packed version of the.
     * encoded MIXChar) performs arithmetic division and
     * remainder operations (in longs) to get each value.
     * back. The values are then matched with values of.
     * within the MIXChar list and if the value equals the.
     * index, it returns the character in the array list. 
     * @return concatenatedString as a string.
     */
    public String toString() {
        List<Character> mixCharSet = MIXChar.createMIXCharList();
       
        
        String finalMessage = ""; 
        
        for (long eachPacked : message) {
            
            boolean flag = true;
            final long fiftySix = 56; 
            long quotient;
            long remainder;
            long currNum = eachPacked;
            while (flag) {
                quotient = Long.divideUnsigned(currNum, fiftySix);
                if (quotient == 0L) {
                    flag = false;
                    remainder = Long.remainderUnsigned(currNum, fiftySix);
                    for (int i = 0; i < mixCharSet.size(); i++) {
                        if (remainder == i) {
                            finalMessage += mixCharSet.get(i);
                           
                        }
                    }
                } else {
                    //flag = false;
                    remainder = Long.remainderUnsigned(currNum, fiftySix);
                    for (int i = 0; i < mixCharSet.size(); i++) {
                        if (remainder == i) {
                            finalMessage += mixCharSet.get(i);
                            
                        }
                    }
                }
                currNum = quotient; 

            }            
        }
        return finalMessage;
        
        
    }
    
    /**
     * The toLongs method returns the each long element.
     * in the long instance array as an unsigned string.
     * @return result as a string.
     */
    public String toLongs() {
        String result = "";
        String currString;
        for (int i = 0; i < message.length; i++) {
            currString = Long.toUnsignedString(message[i]);
            result += currString + " ";
        }
        return result; 
    }
    
}
