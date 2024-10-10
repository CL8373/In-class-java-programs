//**************************************************************
// Stars_CL.java
//
// Purpose: Generates random Stars of random sizes and colors.
// R0: 18-May-2023 Chris Lin - Original version
//**************************************************************

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
public class Stars_CL extends JPanel{
   final int WIDTH = 800;
   final int HEIGHT = 400;
   public Stars_CL() {
      setPreferredSize(new Dimension(WIDTH,HEIGHT));
   }
   public void paintComponent (Graphics page) {
      Color red = new Color(245,11,7);
      Color black = new Color(0,0,0);
      Color lightblue = new Color(5,242,211);
      Color brown = new Color(150,75,0);
      Color orange = new Color(255,165,0);
      page.setColor(brown);
      page.fillRect(0,350,800,50);
      page.setColor(black);
      page.fillRect(0,0,800,350);
      int star = (int)(Math.random()* 5) + 15;
      page.setColor(Color.YELLOW);
      int[] x  = {21,26,36,27,30,20,8,14,5,16,21};
      int [] y = {19,31,32,40,52,43,51,38,29,30,19};
      
      int numstar = (int)(Math.random() * 5) + 15;
      for(int i = 0; i < numstar; i++) // random amount of stars loop
      {
         int size = (int)(Math.random() * 5) + 1;
         int color = (int)(Math.random() * 5) + 1;
         int[] tempx = new int[11]; // new array for star size and positions
         int[] tempy = new int[11];
         int xl = (int)(Math.random()*700); // generate new random positions
         int yl = (int)(Math.random()*300);
         if(size == 1) 
         {
            for(int k = 0; k < tempx.length; k++)
            {
               tempx[k] = x[k] / size; // sizes will be divided by the random number to generate 5 different sizes
               tempy[k] = y[k] / size;
            }
         }
         if(size == 2)
         {
            for(int k = 0; k < tempx.length; k++)
            {
               tempx[k] = x[k] / size;
               tempy[k] = y[k] / size;
            }
         }
         if(size == 3)
         {
            for(int k = 0; k < tempx.length; k++)
            {
               tempx[k] = x[k] / size;
               tempy[k] = y[k] / size;
            }
         }
         if(size == 4)
         {
            for(int k = 0; k < tempx.length; k++)
            {
               tempx[k] = x[k] / size;
               tempy[k] = y[k] / size;
            }
         }
         if(size == 5)
         {
            for(int k = 0; k < tempx.length; k++)
            {
               tempx[k] = x[k] / size;
               tempy[k] = y[k] / size;
            }
         }
         if(color == 1)
         {
            page.setColor(red);
            for(int j = 0; j < tempx.length; j++)
            {
               tempx[j] = tempx[j] + xl; // adds the random number to change its position to somewhere else
               tempy[j] = tempy[j] + yl;
            }
            page.fillPolygon(tempx, tempy, 11);
         }
         if(color == 2)
         {
            page.setColor(orange);
            for(int j = 0; j < tempx.length; j++)
            {
               tempx[j] = tempx[j] + xl;
               tempy[j] = tempy[j] + yl;
            }
            page.fillPolygon(tempx, tempy, 11);
         } 
         if(color == 3)
         {
            page.setColor(Color.YELLOW);
            for(int j = 0; j < tempx.length; j++)
            {
               tempx[j] = tempx[j] + xl;
               tempy[j] = tempy[j] + yl;
            }
            page.fillPolygon(tempx, tempy, 11);
         }
         if(color == 4)
         {
            page.setColor(Color.WHITE);
            for(int j = 0; j < tempx.length; j++)
            {
               tempx[j] = tempx[j] + xl;
               tempy[j] = tempy[j] + yl;
            }
            page.fillPolygon(tempx, tempy, 11);
         }
         if(color == 5)
         {
            page.setColor(lightblue);
            for(int j = 0; j < tempx.length; j++)
            {
               tempx[j] = tempx[j] + xl;
               tempy[j] = tempy[j] + yl;
            }
            page.fillPolygon(tempx, tempy, 11);
         } 
      }    
   }
   public static void main (String[] args) {
      JFrame frame = new JFrame("Stars_CL");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Stars_CL());
      frame.pack();
      frame.setVisible(true);            
   }
}