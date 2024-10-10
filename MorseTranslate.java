//******
//MorseTranslate.java
//
// Purpose: Translate a word to morse and back
//R0: Mar-11-2024 Chris Lin Orginial Version
//********
import java.util.Scanner;
public class MorseTranslate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // letter and morse arrays
        String letters[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String morse[] = {".-", "-...", "-.-.", "-..", ".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        System.out.print("Enter a word:");
        String text = scan.nextLine();
        String uppertext = text.toUpperCase();
        String mConvert = "";
        String symbols = ",./!@#$%^&*()-_`";
        for(int i = 0; i < text.length(); i++) // loop around the letters
        {
            String m = uppertext.substring(i, i+1);
            int pos = 0;
            if(symbols.indexOf(m) <= -1) // checks if it is a symbol
            {
                for(int j = 0; j < letters.length; j++)
                {
                    if(m.equals(letters[j])) // if it is equal to a letter in the array, get position of that array
                    {
                        pos = j;
                    }
                }
                mConvert += morse[pos]; // convert to morse
            }
            else
            {
                mConvert += m;
            }
            mConvert += " ";
        }
        mConvert = mConvert.substring(0,mConvert.length()-1); // added out here to prevent out of bounds error
        System.out.println("Morse is: " + mConvert);
        String wConvert = "";
        int space = mConvert.indexOf(" ");
        int index = 0;
        while(space >= 0) // while loop to find spaces between the morse code
        {
            if(space < 0)
                break;
            int pos = 0;
        
            for(int k = 0; k < morse.length; k++) // convert from morse to english
            {
               if(mConvert.substring(index , space).equals(morse[k]))
               {
                    pos = k;
               } 
            }
            index = space + 1;
            space = mConvert.indexOf(" ", space + 1);
            wConvert += letters[pos];
        }
        for(int j = 0; j < morse.length; j++) // added out here to prevent out of bounds
        {
            int pos = 0;
            if(mConvert.substring(index).equals(morse[j]))
            {
                pos = j;
                if(pos > 0)
                {
                    wConvert += letters[pos];
                }
            }
        }
        System.out.print("The word is: " + wConvert);
    }
}
