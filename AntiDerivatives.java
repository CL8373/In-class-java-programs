//******
//AntiDerivatives.java
//
// Purpose: Solve antiderivatives on a human inputted equation
//R0: Apr-3-2024 Chris Lin Orginial Version
//********

import java.util.Scanner;
public class AntiDerivatives {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an equation(Ex. 3x2 + 4x1 - 5): ");
        String equation = scan.nextLine();
        double base = -123;
        int power = -123;
        int count = 0; // determines whether it is a base or power
        char[] parts = equation.toCharArray(); // turn the string to a char array
        for(int i = 0; i < equation.length() - 1; i++)
        {
            if(Character.isDigit(parts[i]) && (count % 2 == 0)) // checks if the char is a digit
            {
                int next = 0;
                String n = "";
                n += parts[i];
                while(Character.isDigit(parts[i + 1 + next])) // finds any other digits after the first one to see if it is either double digit or more
                {
                    n += parts[i + 1 + next];
                    next++;
                }
                base = Integer.parseInt(String.valueOf(n));
                count++;
            }
            else if(Character.isDigit(parts[i]) && (count % 2 == 1))
            {
                if(parts[i - 1] == 'x') // checks if it is a power by looking for x before it
                {
                    power = Integer.parseInt(String.valueOf(parts[i]));
                    count++;
                }
            }
            if(base != -123 && power != -123) // checks if both base and power is detected
            {
                power++;
                base = base / power;
                System.out.print(base); // prints out the integrated part
                System.out.print(parts[i - 1]);
                System.out.print(power);
                if(power != 0)
                {
                    System.out.print(" + ");
                }
                base = -123;
                power = -123;
            }
        }
        if(Character.isDigit(parts[equation.length()- 1]))
        {
            if(parts[equation.length()-2] == 'x')
            {
                double b = Integer.parseInt(String.valueOf(parts[equation.length() - 3]));
                int p = Integer.parseInt(String.valueOf(parts[equation.length() - 1]));
                p++;
                b = b / p;
                System.out.print(b); // prints out the integrated part
                System.out.print(parts[equation.length()-2]);
                System.out.print(p);
            }
            else
            {
                System.out.print(parts[equation.length()-1]);
                System.out.print("x1");
            }
        }
        
    }
}
