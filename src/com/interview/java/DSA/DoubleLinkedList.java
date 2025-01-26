package com.interview.java.DSA;

public class DoubleLinkedList {
	
	class Node{
		int data;
		Node previous;
		Node next;
		
		Node(int data)
		{
			this.data=data;
		}
		
		
		
	}
	
	Node head,tail=null;
	
	public void insert(int data)
	{
		Node newNode = new Node(data);
		
		if(head==null)
		{
			head=tail=newNode;
			head.previous=null;
			tail.next=null;
		}
		else {
			tail.next=newNode;
			newNode.previous=tail;
			tail= newNode;
			tail.next=null;
		}
	}
	
	
	public void display()
	{
		Node current=head;
		
		if(head==null)
		{
			System.out.println("No Intem in given list : ");
			return;
		}
		
		while(current!=null)
		{
			System.out.println(current.data+" ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
	
		DoubleLinkedList db= new DoubleLinkedList();
		
		db.insert(10);
		db.insert(30);
		db.insert(40);
		
		db.display();

	}

}
