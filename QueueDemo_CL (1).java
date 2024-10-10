//**************************************************************
// QueueDemo_CL.java
//
// Purpose: Showcases the queue class and methods.
// R0: 17-May-2023 Chris Lin - Original version
// R1: fixed display of the queue.
//**************************************************************

import java.util.Scanner;
public class QueueDemo_CL
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      Scanner scan2 = new Scanner(System.in);
      int choice = -1;
      Queue demo = new Queue(" ");
      System.out.println("\n*** Program QueueDemo ***");
      while(choice != 0) // loop to repeat choices until ended
      {
         System.out.print("\n1. Peek item.\n2. Enqueue item.\n3. Dequeue item.\n0. End Program.");
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
            demo.enqueue(r);
         }
         if(choice == 3)
         {
            System.out.println("Dequeued: " + demo.dequeue());
         }
      }
      System.out.print("\nDone!");
   }
}

class Queue
{
   public ListNode head;
   public ListNode tail;
   public Queue(String payload)
   {
      head = new ListNode(payload,null); // creates a new ListNode and turn it to null
      head = head.getNext();
      tail = head;
      
   }
   public String peek() // peek
   {
      if(head == null)
      {
         return "Empty!";
      }
      ListNode temp = head;
      while(temp.getNext() != null)
      {
         temp = temp.getNext();
      }
      return head.getVal();
   }
   public String dequeue()// dequeue
   {
      if(head == null)
      {
         return "Empty!";
      }
      String p = head.getVal();
      ListNode temp = head;
      head = head.getNext(); // the top of the stack is now equal to the next Listnode in the dequeue listnode
      return p;
   }
   public void enqueue(String str) //enqueue
   {
      ListNode temp = new ListNode(str,null); 
      if (head == null) // if empty head and tail is the same
      {
         head = temp;
         tail = temp;
      }
      else // else then set next to temp and tail would equal to temp
      {
         tail.setNext(temp);
         tail = temp;
      }
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