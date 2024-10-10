//**************************************************************
// StackDemo_CL.java
//
// Purpose: Showcases the stack class and methods.
// R0: 17-May-2023 Chris Lin - Original version
//**************************************************************

import java.util.Scanner;
public class StackDemo_CL
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      Scanner scan2 = new Scanner(System.in);
      int choice = -1;
      Stack demo = new Stack(" ");
      System.out.println("\n*** Program StackDemo ***");
      while(choice != 0) // loop to repeat choices until ended
      {
         System.out.print("\n1. Peek item.\n2. Push item.\n3. Pop item.\n0. End Program.");
         System.out.print("\n\nYour Choice? ");
         choice = scan.nextInt();
         if(choice == 1)
         {
            System.out.println("Peeked: " + demo.peek());
         }
         if(choice == 2)
         {
            System.out.print("\nEnter String: ");
            String r = scan2.nextLine();
            demo.push(r);
         }
         if(choice == 3)
         {
            System.out.println("Popped: " + demo.pop());
         }
      }
   }
}

class Stack
{
   public ListNode head;
   public Stack(String payload)
   {
      head = new ListNode(payload,null); // creates a new ListNode and turn it to null
      head = head.getNext();
   }
   public String peek() // peek
   {
      if(head == null)
      {
         return "Empty!";
      }
      return head.getVal();
   }
   public String pop()// pop
   {
      if(head == null)
      {
         return "Empty!";
      }
      String p = head.getVal();
      head = head.getNext(); // the top of the stack is now equal to the next Listnode in the popped listnode
      return p;
   }
   public void push(String str) //push
   {
      ListNode temp = new ListNode(str,head); // makes new Listnode and change the top of the stack to the new Listnode
      head = temp;
      
   }
}

class ListNode
{
   private String val;
   private ListNode n;
   
   public ListNode(String payload, ListNode next) // listnode constructor
   {
      val = payload;
      n = next;
   }
   public ListNode getNext()
   {
      return n;
   }
   public String getVal()
   {
      return val;
   }
   public void setNext(ListNode next)
   {
      n = next;
   }
   public void setVal(String str)
   {
      val = str;
   }
}