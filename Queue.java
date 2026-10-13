class Queue {
    int[] Array;
    int front, rear, Size;

    public Queue(int n) {
        Array = new int[n];
        front = -1;
        rear = -1;
        Size = n;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % Size == front;
    }

    public void enqueue(int x) {
        if (isFull()) return;

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % Size;
        Array[rear] = x;
    }

    public void dequeue() {
        if (isEmpty()) return;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % Size;
        }
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return Array[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return Array[rear];
    }
}