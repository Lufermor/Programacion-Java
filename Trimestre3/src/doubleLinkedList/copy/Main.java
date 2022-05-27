package doubleLinkedList.copy;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedList l = new DoubleLinkedList();
		for(int i= 1; i<= 10; i++) { l.add(new Node(i*3, null, null));
//			Node p = new Node(i*3, null);
//			l.add(p);
		}l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.add(7, new Node(23, null, null));
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.add(7, new Node(22, null, null));
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.delete(12);
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.delete(11);
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.delete(0);
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
		l.delete(7);
		l.show();
		System.out.println("\nFirst = "+l.getFirst().getContent() + 
				" Next:" + l.getFirst().getNext().getContent() + 
				"\nLast = " + l.getLast().getContent() + 
				" Prev:" + l.getLast().getPrevious().getContent()); 
//		System.out.println("\n first = "+l.getFirst().getContent() + " last = " + l.getLast().getContent());
		System.out.println("--------------");
		System.out.println(l.get(0));
		System.out.println(l.getSize());
		System.out.println(l.get(2));
		System.out.println(l.get(l.getSize()));
		System.out.println(l.getSize());
		System.out.println(l.get(l.getSize()-1));
	}
}
