//******
//PasswordStrengthener.java
//
// Purpose: It takes a password and choose random methods to split up or add things to a password to strengthen it.
//R0: May-15-2024 Chris Lin Orginial Version
//********
import java.util.Scanner;
public class PasswordStrengthener {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        String password = scan.nextLine();
        int iteration = 5;
        for(int index = 0; index < iteration; index++){
            int random = (int)((Math.random()*3)+1); //chooses random method to change password
            if(random == 1){
                password = method1(password);
            }
            else if(random == 2){
                password = method2(password);
            }
            else{
                password = method3(password);
            }
        }
        System.out.print("Here is your new password: " + password);

    }

    public static String method1(String pass){
        int num = (int)((Math.random()*3)+1);
        for(int i = 0; i < num; i++){ // random iteration of method
            int choice = (int)((Math.random()*2)+1); // random choice to add symbols
            if(choice == 1){
                pass += "!";
            }
            else{
                pass += "?";
            }
        }
        return pass;
    }

    public static String method2(String pass){
        int num = (int)((Math.random()*3)+1);
        for(int i = 0; i < num; i++){
            int split = (int)(((Math.random()*pass.length())/2)+1); // makes a random split in the password
            String part1 = pass.substring(0,split); // flips the split substrings around
            String part2 = pass.substring(split); 
            pass = part2; // add back to password
            pass += part1;
        }
        return pass;
    }

    public static String method3(String pass){
        String mix = "";
        for(int i = 0; i < pass.length(); i++){
            int num = (int)(Math.random()); 
            if(num == 0){ // random choice to capitalize the character at position i
                mix += pass.substring(i,i+1).toUpperCase();
            }
            else{
                mix += pass.substring(i,i+1);
            }
        }
        return mix;
    }
}
