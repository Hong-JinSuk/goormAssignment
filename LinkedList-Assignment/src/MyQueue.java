public class MyQueue<T> {
    private MyLinkedList<T> q = new MyLinkedList<>();

    // 요소를 큐에 추가
    public void enqueue(T element) {
        q.add(element);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return q.get(0);
    }

    // 큐에서 요소를 제거하고 반환
    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        T element = q.get(0);
        q.delete(0);
        return element;
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return q.getSize() == 0;
    }

    // 큐의 크기 반환
    public int size() {
        return q.getSize();
    }
}
