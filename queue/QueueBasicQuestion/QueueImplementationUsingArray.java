/**
 * Queue implementation using Array.
 */
package Queue.QueueBasicQuestion;

public class QueueImplementationUsingArray {

	int front, rear, size;
	int capacity;
	int queue[];

	public QueueImplementationUsingArray(int capacity) {

		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		queue = new int[this.capacity];
	}

	boolean isFull(QueueImplementationUsingArray queue) {
		return (queue.size == queue.capacity);
	}

	boolean isEmpty(QueueImplementationUsingArray queue) {
		return (queue.size == 0);
	}

	void EnqueData(int data) {

		if (isFull(this)) {
			return;
		}

		this.rear = (this.rear + 1) % this.capacity;
		this.queue[this.rear] = data;
		this.size = this.size + 1;
		System.out.println(data + " is enqued in queue");
	}

	int DequeueData() {

		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}

		int item = this.queue[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;

		return item;
	}

	int queueFront() {

		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}

		return this.queue[this.front];
	}

	int queuerear() {

		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}

		return this.queue[this.rear];
	}

	public static void main(String[] args) {

		QueueImplementationUsingArray queueImplementation = new QueueImplementationUsingArray(100);

		queueImplementation.EnqueData(10);
		queueImplementation.EnqueData(20);
		queueImplementation.EnqueData(30);
		queueImplementation.EnqueData(40);

		System.out.println(queueImplementation.DequeueData() + " Dequeue from queue");
		queueImplementation.EnqueData(300);

		System.out.println("Front item is : " + queueImplementation.queueFront());

		System.out.println("Rear item is : " + queueImplementation.queuerear());
	}
}