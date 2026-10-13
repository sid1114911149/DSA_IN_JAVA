class Stack {
    int Array[];
    int top;
    int Size;
    public Stack(int n) {
        // Define Data Structures
        Array=new int[n];
        top=-1;
        Size=n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top==-1?true:false;
    }

    public boolean isFull() {
        // check if the stack is full
        return top==Size-1?true:false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(!isFull())
            Array[++top]=x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(!isEmpty())
            top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(!isEmpty())
            return Array[top];
        return -1;
    }
}