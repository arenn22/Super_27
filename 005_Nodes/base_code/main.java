import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		
		List<Node<Integer>> arrayList = new ArrayList<>();
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			arrayList.add(new Node<Integer>(r.nextInt(100)));
		}

		for (Node<Integer> node : arrayList) {
			System.out.println(node.getValue());
		}
	}
}
