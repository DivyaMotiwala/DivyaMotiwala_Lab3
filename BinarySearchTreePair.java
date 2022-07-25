/**
 * 
 */
package com.gl.bstpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Divya
 *
 */
public class BinarySearchTreePair {
	
	//Global vairables
	Node root;
	List<Integer> inorderList = new ArrayList<Integer>();

	//Constructor
	public BinarySearchTreePair() {
		root = null;
	}
	
	//Insert and create tree
	public void insert(int value)
	{
		root = insertNode(root, value);
	}
	public Node insertNode(Node root, int value)
	{
		if(root == null)
			root = new Node(value);
		else if(value > root.key)
			root.right = insertNode(root.right, value);
		else if(value < root.key)
			root.left = insertNode(root.left, value);
		return root;
	}
	
	//Store tree in inorder format in an array
	public void inorderToArray()
	{
		inorderTraversal(root);
	}
	public void inorderTraversal(Node root)
	{
		if(root != null)
		{
			inorderTraversal(root.left);
			inorderList.add(root.key);
			inorderTraversal(root.right);
		}
	}
	
	//Find Pair
	public int[] isPairPresent(int targetSum)
	{
		int start =0, end= inorderList.size()-1;
		while( start <= end)
		{
			int searchElement = targetSum - inorderList.get(start);
			int index = inorderList.indexOf(searchElement);
			if( index != -1)
				return new int[] {inorderList.get(start),searchElement};
			else if(searchElement < inorderList.get(end))
				end--;
			else
				start++;
		}
		return null;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTreePair bstTree = new BinarySearchTreePair();
		bstTree.insert(50);
		bstTree.insert(40);
		bstTree.insert(60);
		bstTree.insert(20);
		bstTree.insert(10);
		bstTree.insert(55);
		bstTree.insert(80);
		
		bstTree.inorderToArray();
		
		int[] resultPair = bstTree.isPairPresent(90);
		if(resultPair != null)
			System.out.println(Arrays.toString(resultPair));
		else
			System.out.println("Pair not found!");
	}

	
}
