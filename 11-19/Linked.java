public class Linked {
	
	public static Node buildLinked() {
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);
	Node n5 = new Node(5);
	Node n6 = new Node(6);
	
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;
	n5.next = n6;
	
	return n1;
	}
	
	public static void printLinked(Node head) {
		Node cur = head;
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
	public static Node pushBack(Node head,int val) {
		Node node = buildLinked();
		if(head == null) {
			return node;
		} else {
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = node;
			return head;
		}
	}
	
	public static Node popBack(Node head) {
		if(head == null) {
			throw new RuntimeException("kong");
		}
		if(head.next == null) {
			return null;
		} else {
			Node cur = head;
			while(cur.next.next != null) {
				cur = cur.next;
			}
			cur.next = null;
			return head;
		}
	}
	public static void main(String[] args) {
		Node head = null;
		head = pushBack(head,1);
		head = pushBack(head,2);
		head = pushBack(head,3);
		head = pushBack(head,4);
		head = pushBack(head,5);
		head = pushBack(head,6);
		printLinked(head);
		
		head = popBack(head);
		head = popBack(head);
		head = popBack(head);
		printLinked(head);
	}
}