package queue.QueueBasicQuestion;

public class QueueImplementation {
	
	private static int front, rear, capacity;
	private static int queue[];
	
	public QueueImplementation(int p) {
		// TODO Auto-generated constructor stub
		front = rear = 0;
		capacity = p;
		queue = new int[capacity];
	}
	
	void queueEnque(int data) {
		if (capacity == rear) {
			System.out.println("Queue is full");
		} else {
			queue[rear] = data;
			rear++;
		}
		
	}
	
	void queueDequeue() {
		if (front == rear) {
			System.out.println("Queue is empty");
			return;
		} else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i+1];
			}
			
			if (rear < capacity) {
				queue[rear] = 0;
			}
			rear --;
		}
		return;
	}
	
	void queueDisplay() {
		if (front == rear) {
			System.out.println("Queue is empty");
			return;			
		}
		for (int i = 0; i < rear; i++) {
			System.out.printf("%d <--", queue[i]);
		}
		return;
	}
	
	static void queueFront() {
		if (front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.printf("Front element is = %d", queue[front]);
		return;
	}

	public static void main(String[] args) {
		
		
		QueueImplementation queueImplementation = new QueueImplementation(5);
		
		queueImplementation.queueDisplay();
		
		queueImplementation.queueEnque(10);
		queueImplementation.queueEnque(20);
		queueImplementation.queueEnque(30);
		queueImplementation.queueEnque(100);
		
		queueImplementation.queueDisplay();
		
		queueImplementation.queueEnque(300);
		
		queueImplementation.queueDequeue();
		
		System.out.printf("\nAfter delete the queue is\n");
		queueImplementation.queueDisplay();
		
		queueImplementation.queueDequeue();
				
	}

}
