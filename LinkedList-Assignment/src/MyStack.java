public class MyStack<T> {
    private MyLinkedList<T> s = new MyLinkedList<>();

    // 요소를 스택에 추가
    public void push(T element) {
        s.add(element);
    }

    // 스택에서 Top 제거 및 반환
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T element = s.get(s.getSize() - 1);
        s.delete(s.getSize() - 1);
        return element;
    }

    // 스택의 Top 반환
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return s.get(s.getSize() - 1);
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return s.getSize() == 0;
    }

    // 스택의 크기 반환
    public int size() {
        return s.getSize();
    }
}
