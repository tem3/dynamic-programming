package cracking;

import java.util.Stack;

public class TowerOfHanoi {
	Stack<Integer> stack1, stack2, stack3;
	int n;
	public TowerOfHanoi(int n) {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		stack3 = new Stack<Integer>();
		this.n = n;
		for(int i = n; i > 0; i--) {
			stack1.push(i);
		}
		move(n, stack1, stack3);
		System.out.println(stack1+"\n"+stack2+"\n"+stack3);
	}
	public Stack<Integer> getOtherTower(Stack<Integer> obj1, Stack<Integer> obj2) {
		if(obj1 != stack1 && obj2 != stack1) {
			return stack1;
		} else if( obj1 != stack2 && obj2 != stack2) {
			return stack2;
		} else {
			return stack3;
		}
	}
	
	public void move(int numDisks, Stack<Integer> fromStack, Stack<Integer> toStack) {
		Stack<Integer> otherStack = getOtherTower(fromStack, toStack);
		System.out.println(numDisks+":\n"+stack1+"\n"+stack2+"\n"+stack3);
		if(numDisks <= 0) {
			return;
		}
		move(numDisks-1, fromStack, otherStack);
		int disk = fromStack.pop();
		toStack.push(disk);
		move(numDisks-1, otherStack, toStack);	
	}
	public static void solve(int num, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
		if(stack1.size() == 1 && stack2.size() == num-1) {
			//base case
			int biggest = stack1.pop();
			stack3.push(biggest);
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoi t = new TowerOfHanoi(5);
		
		
	}

}
