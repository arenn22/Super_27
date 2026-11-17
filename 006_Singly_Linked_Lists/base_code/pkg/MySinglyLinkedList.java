package pkg;
import java.util.Scanner;
import java.util.Random;


public class MySinglyLinkedList {
	Node head;

	/* 
		Postcondition: The head will be null 
	*/
	public MySinglyLinkedList() {
		head = null;
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos){
		int i = 0;

		for(Node cur = head; cur != null; cur = cur.getNext()){
			if (pos == i) {
				return cur.getData();
			}

			i++;
		}

		return -1;
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data){
		if (pos < 0) {
			return;
		}

		Node n = new Node(data);
		
		if (pos == 0) {
			n.setNext(head);
			head = n;
			return;
		}
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){

	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){
		for(Node cur = head; cur != null; cur = cur.getNext()){
			System.out.print(cur.getData() + " ");
		}
		
		System.out.println();
	}
}
