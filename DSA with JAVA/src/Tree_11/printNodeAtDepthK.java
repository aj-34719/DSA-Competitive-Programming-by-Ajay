package Tree_11;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class printNodeAtDepthK {

	public static treeNode<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Root : ");
		int data = sc.nextInt();
		treeNode<Integer> root = new treeNode<Integer>(data);
		
		Queue<treeNode<Integer>> pending = new LinkedList<>();
		pending.add(root);
		
		while(!pending.isEmpty()) {
			treeNode<Integer> front = pending.poll();
			System.out.println("Enter no. of child for " + front.data + " : ");
			int n = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				System.out.println("Enter " + (i+1) + " child");
				int childData = sc.nextInt();
				treeNode<Integer> child = new treeNode<Integer>(childData);
				front.children.add(child);
				pending.add(child);
			}
		}
		return root;
	}
	
	public static void printAtDepthK(treeNode<Integer> root, int k) {
		if(root == null || k<0)
			return;
		if(k==0) {
			System.out.print(root.data + " ");
			return ;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			printAtDepthK(root.children.get(i), k-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		treeNode<Integer> root = takeInput();
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		printAtDepthK(root, k);
	}

}
