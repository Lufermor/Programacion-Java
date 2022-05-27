package examenProgramacionMayo2022;

/*
 * Clase que sirve para crear objetos que actúen de nodo en una lista enlazada
 */

public class Node {
	private int content;
	private Node next;
	
	public Node(int content) {
		this.content = content;
		this.next = null;
	}
	
	public Node(int content, Node next) {
		this.content = content;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}
	
}
