package com.interview.java.DSA;

public class LinkedListed {

	
	class Node {
		
		int data;
		Node next;
		
		Node(int d)
		{
			this.data=d;
			this.next=null;
		}
	}
	
	
	public Node head=null;
	public Node tail=null;
	
//	insert function()
	
	public void insertAtStart(int data)
	{
		System.out.print("Inserted a start");
		Node newNode = new Node(data);
//		 checking if the list is empty
		
		if(head==null)
		{
//			 if the given list is empty then head and tail pointing to the same node
			
			head= newNode;
			tail= newNode;
			
		}else {
//			other wise add the new node to tail 
			
			tail.next=newNode;
			tail=newNode;
		}
	}
	
	
	public void insertAtEnd(int data)
	{
		System.out.println("Adding a node at the end of the list ");
		Node newNode= new Node(data);
		
		// checking given list is empty or not
		if(this.head== null)
		{
			this.head = newNode;
		}else {
			// create a new Node call current
			
			Node current = this.head;
			
			while(current.next!=null)
			{
				current = current.next;
			}
			
			current.next = newNode;
		}
	}
	
	
	//Delete from begning
	
	public void deleteFromBegning()
	{
		System.out.println("Delete from Begning : ");
		
		if(this.head == null)
		{
			System.out.println("The given list is Empty ");
			return;
		}else {
			head = head.next;
		}
	}
	
	
	
	
//defining displaylist() function to display the data in the list  
	
	public void displayList()
	{
		Node current = head;
		
		if(head == null)
		{
			System.out.println("The Given list is Empty");
			return ;
		}
		System.out.println("The data in given list are : ");
		
		while(current!=null)
		{
			System.out.println(current.data+" ");
			current= current.next;
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		LinkedListed ls = new LinkedListed();
		ls.insertAtStart(10);
		ls.insertAtStart(20);
		ls.insertAtStart(30);
		
		ls.displayList();
		ls.insertAtEnd(50);
		ls.insertAtEnd(100);
		ls.insertAtStart(0);
		ls.displayList();
		ls.deleteFromBegning();
		ls.displayList();
	}
	
}
