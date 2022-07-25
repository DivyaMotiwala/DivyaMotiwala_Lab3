/**
 * 
 */
package com.gl.practice;

import java.util.Stack;

/**
 * @author Divya
 *
 */
public class BalancedBrackets {

	Stack<Character> stack = new Stack<Character>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BalancedBrackets bracketObject = new BalancedBrackets();
		 //String bracketString = "([[{}]])";
		String bracketString = "[()]{}[()()][()]";
		//String bracketString = "[(){]{}[()()][()]";
		
		if (bracketObject.checkBalancedBrackets(bracketString))
			System.out.println("String is balanced!");
		else
			System.out.println("String is not balanced!");

	}

	public boolean checkBalancedBrackets(String bracketString) {

		for (Character ch : bracketString.toCharArray()) {
			switch (ch) {
			case '(':
			case '[':
			case '{':
				stack.push(ch);
				break;
			case ')':
				if(!checkCharacter('('))
					return false;
				break;

			case ']':
				if(!checkCharacter('['))
					return false;
				break;
			case '}':
				if(!checkCharacter('{'))
					return false;
				break;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}

	
	private boolean checkCharacter(Character outputCh) {
		if (!stack.isEmpty()) {
			if (stack.peek() == outputCh)
			{
				stack.pop();
				return true;
			}
			else
				return false;
		} 
		else
			return false;
		
	}

}
