package stack.stackBasicQuestions;

public class FindMiddleElementOfStack {


    public class DLLNode {

        int data;
        DLLNode nextNode;
        DLLNode prevNode;

        public DLLNode(int data) {
            this.data = data;
        }
    }

    class myStack {
        DLLNode headNode;
        DLLNode midNode;
        int count;
    }

    myStack createMyStack() {

        myStack ms = new myStack();
        ms.count = 0;
        return ms;

    }
}