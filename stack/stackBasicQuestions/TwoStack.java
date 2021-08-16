/**
 * Write a program to implement two stack in an array
 */
package stack.stackBasicQuestions;

public class TwoStack {

	// Declare variables
	int size;
	int top1, top2;
	int arr[];

	// Constructor
	public TwoStack(int n) {
		size = n;
		arr = new int[n];
		top1 = -1;
		top2 = size;
	}

	// Method to push element into the stack 1
	void push1(int x) {

		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	// Method to push element into the stack 2
	void push2(int x) {

		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	// Method to pop element from stack 1
	int pop1() {

		if (top1 >= 0) {
			int x = arr[top1];
			top1--;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	// Method to pop element from stack 2
	int pop2() {

		if (top2 < size) {
			int x = arr[top2];
			top2++;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	public static void main(String[] args) {

		TwoStack twoStack = new TwoStack(5);
		twoStack.push1(10);
		twoStack.push2(5);
		twoStack.push1(12);
		twoStack.push2(30);
		twoStack.push1(4);

		System.out.println("Popped element from stack1 is = " + twoStack.pop1());

		System.out.println("Popped element from stack2 is = " + twoStack.pop2());
	}
}