//**************************************************************
// Decipher_CL.java
//
// Purpose: Deciphers a text by shifting the letters.
// R0: 28-Apr-2023 Chris Lin - Original version
//**************************************************************

import java.util.Scanner;
public class Decipher_CL
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      String letters = "abcdefghijklmnopqrstuvwxyz";
      String uletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String nletters = "? ,.!@#$%^&*:;-_\"";
      System.out.print("*** Program Decipher ***\n\nEnter ciphertext: ");
      String sentence = scan.nextLine();
      String us = sentence.toUpperCase();
      for(int i = 1; i < 26; i++) //prints the text 25 times
      {
         System.out.print(i + ": ");
         for(int k = 0; k < sentence.length() - 1; k++) //loop that checks each letter
         {
            char le = sentence.charAt(k); // creates a char from the index of the string
            while(nletters.indexOf(le) >= 0) // checks if the char is not a letter
            {
               System.out.print(sentence.charAt(k));
               k++;
               le = sentence.charAt(k);
            }
            if(us.indexOf(le)>=0) // checks if it is uppercase and prints out the uppercase letter when true
            {
               int pos = uletters.indexOf(le); //gets position of the char in the letters string and shifts the letter position
               pos = (pos + i) % 26;
               System.out.print(uletters.charAt(pos));// print the letter
            }
            else // checks if lowercase
            {
               int pos = letters.indexOf(le);
               pos = (pos + i) % 26;
               System.out.print(letters.charAt(pos));
            }
         }
         char temp = sentence.charAt(sentence.length() - 1); // prints the last char in the string to avoid index out of bounds error
         if(nletters.indexOf(temp) >= 0)
         {
            System.out.print(temp);
         }
         else if(us.indexOf(temp)>=0)
         {
         int pos = uletters.indexOf(temp);
         pos = (pos + i) % 26;
         System.out.print(uletters.charAt(pos));
         }
         else
         {
         int pos = letters.indexOf(temp);
         pos = (pos + i) % 26;
         System.out.print(letters.charAt(pos));
         }
         System.out.println();
      }
      
   }
}