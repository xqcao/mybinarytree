import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Mybinarytree {

	class Node {
		int value;
		Node left;
		Node right;

		Node(int val) {
			this.value = val;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

		public void insert2(Node newnode) {//BST
			if (newnode.value < value ) {
				if(left == null) {
					left = newnode;
				} else {
					left.insert2(newnode);
				}
			} else {
				if (right == null){
					right = newnode;
					
				} else {
					right.insert2(newnode);
				}
			}
		}
		
		public void insertRec(Node newnode) {			
				if(left == null) {
					left = newnode;
					return;
				} else {
					if (right == null) {
						right = newnode;
						return;
					}else {
						left.insertRec(newnode);
					}
				}			
				/*if (right == null){
					right = newnode;
					return;				
				}*/	
		}
	}

	Node root;

	public Mybinarytree() {
		this.root = null;
	}
	public void insert2(int value) {
		Node newnode = new Node(value);
		if (root ==null) {
		    root = newnode;
		} else {
			root.insert2(newnode);
		}
	}
	public void insert1(int value) {
		Node node = new Node(value);
		//Stack<Node> sk = new Stack<Node>();
		//Queue<Node> sk = new LinkedList<Node>();
		LinkedList<Node> sk = new LinkedList<Node>();
		if (root == null) {
			root = node;
		}else {
			sk.addLast(root); 	
			//System.out.println("root value"+root.value);
			while (sk.size() != 0) {
				//Node nd = sk.poll();
				Node nd = sk.pop();
				
				//System.out.println("nd value1="+nd.value);
				if(nd.left == null){
					nd.left = node;
					return;
				} else {
					//System.out.println("nd left value2="+nd.left.value);					
					//sk.addLast(nd.left);
					sk.addLast(nd.left);
				} 				
				if(nd.right == null){
					nd.right = node;

					return;
				} else {
					//System.out.println("nd right value3="+nd.right.value);				
					sk.addLast(nd.right);
				} 		
			}
		}
	
	}
	
	public void insertRec(int value) {
		Node newnode = new Node(value);
		if (root == null) {
			root = newnode;
		} else {
			root.insertRec(newnode);
		}
		
	}
	
	
	
	
	public void insert(int value) {
		Node node = new Node(value);
		//Stack<Node> sk = new Stack<Node>();
		//Queue<Node> sk = new LinkedList<Node>();
		LinkedList<Node> sk = new LinkedList<Node>();
		if (root == null) {
			root = node;
		}else {
			sk.addLast(root); 	
			//System.out.println("root value"+root.value);
			while (sk.size() != 0) {
				//Node nd = sk.poll();
				Node nd = sk.pop();
				
				//System.out.println("nd value1="+nd.value);
				if(nd.left == null){
					nd.left = node;
					return;
				} else {
					//System.out.println("nd left value2="+nd.left.value);					
					//sk.addLast(nd.left);
					sk.addLast(nd.left);
				} 				
				if(nd.right == null){
					nd.right = node;

					return;
				} else {
					//System.out.println("nd right value3="+nd.right.value);				
					sk.addLast(nd.right);
				} 		
			}
		}
	
	}
	
	
	
	public void bylevel() {
		Stack<Node> levsk = new Stack<Node>();
		levsk.push(root);
		while(levsk.size() != 0) {
			Node node = levsk.pop();
			//System.out.println(node);
			System.out.print(node.value + " ");
			if (node.left != null) {
				levsk.push(node.left);
			}
			if (node.right != null) {
				levsk.push(node.right);
			}
		}		
	}
	public String findnode(int val) {
		Stack<Node> fd = new Stack<Node>();
		fd.push(root);
		while(fd.size() != 0){
			Node nd = fd.pop();
			if (nd.value == val ) {
				return "found node "+val;
			} else {
				if(nd.left != null) {
					fd.push(nd.left);
				}
				if(nd.right != null) {
					fd.push(nd.right);
				}			
			}
		}
		return "no found  " + val;
	}
	public int nodestotal( Node node) {
		if (node == null) {
			return 0;
		} else {
			int L = nodestotal( node.left);
			int R = nodestotal( node.right);
			return L + R +1;
		}
		
	}
	public int level(Node node) {
		if (node == null) {
			return 0;
		} else {
		    	int	L_height = level(node.left);
		    	int	R_height = level(node.right);
		    	return L_height > R_height ? L_height +1 : R_height +1;			
		}
	}
	public void traverseByLevelFromTop(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(node);
		int incount = 1;
		int outcount = 0;
		while (!queue.isEmpty()) {
			Node curnode = queue.pollFirst();

			System.out.print(curnode.value + " ");

			outcount++;
			if (curnode.left != null) {
				queue.addLast(curnode.left);
			}
			if (curnode.right != null) {
				queue.addLast(curnode.right);
			}
			if (outcount == incount) {
				System.out.println();
				incount = queue.size();
				outcount = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Mybinarytree alist = new Mybinarytree();
		 
		/*alist.insert(30);
		alist.insert(23);
		alist.insert(40);
		alist.insert(20);
		alist.insert(26);
		alist.insert(35);
		alist.insert(50);
		alist.insert(15);
		alist.insert(22);
		alist.insert(24);
		alist.insert(27);
		alist.insert(32);
		alist.insert(36);
		alist.insert(45);
		alist.insert(55);*/

		
		/*alist.insert2(30);
		alist.insert2(23);
		alist.insert2(40);
		alist.insert2(20);
		alist.insert2(26);
		alist.insert2(35);
		alist.insert2(50);
		alist.insert2(15);
		alist.insert2(22);
		alist.insert2(24);
		alist.insert2(27);
		alist.insert2(32);
		alist.insert2(36);
		alist.insert2(45);
		alist.insert2(55);*/

		
		alist.insertRec(30);
		alist.insertRec(23);
		alist.insertRec(40);
		alist.insertRec(20);
		alist.insertRec(26);
		alist.insertRec(35);
		alist.insertRec(50);
		alist.insertRec(15);
		alist.insertRec(22);
		alist.insertRec(24);
		alist.insertRec(27);
		alist.insertRec(32);
		alist.insertRec(36);
		alist.insertRec(45);
		alist.insertRec(55);
		alist.insertRec(999);

		alist.traverseByLevelFromTop(alist.root);
		//alist.bylevel();
		System.out.println();
		System.out.println("total number of node rec="+alist.nodestotal(alist.root));
		System.out.println("height of tree ="+alist.level(alist.root));
		System.out.println(alist.findnode(90));
		System.out.println(alist.findnode(32));
		
		
	}
}