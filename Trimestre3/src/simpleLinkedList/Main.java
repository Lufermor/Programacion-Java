package simpleLinkedList;

public class Main {
	public static void main(String[] args) {
		SimpleLinkedList l = new SimpleLinkedList();
		for(int i= 1; i<= 10; i++) { l.add(new Node(i*3, null));
//			Node p = new Node(i*3, null);
//			l.add(p);
		}l.show();
		l.add(7, new Node(23, null));
		l.show();
		l.add(7, new Node(22, null));
		l.show();
		l.delete(12);
		l.show();
		l.delete(11);
		l.show();
		l.delete(0);
		l.show();
		l.delete(7);
		l.show();
		System.out.println(l.get(0));
		System.out.println(l.getSize());
		System.out.println(l.get(2));
		System.out.println(l.get(l.getSize()));
		System.out.println(l.getSize());
		System.out.println(l.get(l.getSize()-1));
	}
}
