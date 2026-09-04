package pkg;
import java.util.*;
import java.io.*;

public class Message {
	private String author;
	private String subject;
	private String body;
	private int id;
	private ArrayList<Message> childList = new ArrayList<Message>();

	// Default Constructor
	public Message() {
		this.author = "";
		this.subject = "";
		this.body = "";
		this.id = 0;
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		this.author = auth;
		this.subject = subj;
		this.body = bod;
		this.id = i;
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation){
		String indentationString = "";
		for (int i = 0; i < indentation; i++) {
			indentationString += "  ";
		}

		System.out.println(String.format("%sMessage #%d: \"%s\"", indentationString, this.id, this.subject));
		System.out.println(String.format("%sFrom %s: \"%s\"", indentationString, this.author, this.body));

		for (Message child : this.childList) {
			child.print(indentation + 1);
		}
	}

	// Default function for inheritance
	public boolean isReply(){
		return false;
	}

	// Returns the subject String
	public String getSubject(){
		return this.subject;
	} 

	// Returns the ID
	public int getId(){
		return this.id;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		this.childList.add(child);
	}

}
