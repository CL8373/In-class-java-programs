//******
//Maze_CL.java
//
// Purpose: Simulates a maze game on a char array
//R0: Jan-26-2024 Chris Lin Orginial Version
//********
import java.util.Scanner;
public class Maze_CL 
{
    public static char[][] maze =
    {
        {'S', ' ', ' ', '@', ' ', ' ', ' ', ' '}, // maze format
        {'@', '@', ' ', '@', ' ', '@', '@', '@'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', '@'},
        {' ', '@', '@', '@', '@', '@', '@', '@'},
        {' ', ' ', ' ', ' ', ' ', ' ', '@', '@'},
        {' ', ' ', ' ', '@', ' ', ' ', ' ', ' '},
        {'@', '@', ' ', '@', '@', '@', '@', ' '},
        {' ', ' ', ' ', '@', ' ', ' ', ' ', ' '},
        {' ', '@', '@', '@', ' ', '@', '@', '@'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E'}
    };
     public static int prow = 0;
     public static int pcol = 0;

     public static void displayMaze() {
        for (char[] row : maze) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void movePlayer()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Use W/A/S/D keys to move(one at a time): ");
        char key = scan.next().charAt(0); // gets the key from human input
        if(key == 'W')
        {
            if(validMove(prow - 1, pcol)) // if it is a valid move, leave asterisk behind and move in direction of key
            {
                maze[prow][pcol] = '*';
                prow--;
            }
            else
            {
                System.out.println("Invalid move! Try again!");
            }
        }
        if(key == 'A')
        {
            if(validMove(prow, pcol - 1))
            {
                maze[prow][pcol] = '*';
                pcol--;
            }
            else
            {
                System.out.println("Invalid move! Try again!");
            }
        }
        if(key == 'S')
        {
            if(validMove(prow + 1, pcol))
            {
                maze[prow][pcol] = '*';
                prow++;
            }
            else
            {
                System.out.println("Invalid move! Try again!");
            }
        }
        if(key == 'D')
        {
            if(validMove(prow, pcol + 1))
            {
                maze[prow][pcol] = '*';
                pcol++;
            }
            else
            {
                System.out.println("Invalid move! Try again!");
            }
        }

    }

    public static boolean validMove(int row, int col)
    {
        if(row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != '@') // checks to make sure it doesn't go out of bounds and not hit a wall
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        displayMaze();
        boolean flag = true;
        while(flag)
        {
            movePlayer();
            displayMaze();
            if(maze[prow][pcol] == 'E'){
                System.out.println("Congrats, You escaped!");
                flag = false;
            }
        }
    }
}
