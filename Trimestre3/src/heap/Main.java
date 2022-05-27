package heap;

public class Main {
	public static void main(String[] args) {
		Heap l = new Heap();
		for(int i= 1; i<= 10; i++) { l.push(new Node(i, null));
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
		for(int i=0;i<4;i++) {
			System.out.println("----");
			l.push(l.pop()); l.show();
		}
		System.out.println(l);
	}
}
