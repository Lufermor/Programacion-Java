package stack;

public class Main {
	public static void main(String[] args) {
		Stack l = new Stack();
		for(int i= 1; i<= 10; i++) { l.push(new Node(i*3, null));
//			Node p = new Node(i*3, null);
//			l.add(p);
		}l.show();
		l.push(new Node(23, null));
		l.show();
		l.push(new Node(22, null));
		l.show();
		System.out.println(l.pop());
		l.show();
		System.out.println(l.pop());
		l.show();
		System.out.println(l.pop());
		l.show();
		System.out.println(l.pop());
		l.show();
	}
}
