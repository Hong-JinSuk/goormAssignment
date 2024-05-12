import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    private Node<T> root;

    public int getSize() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next; // 이어질 다음 노드

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // i번째 노드의 data를 return
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    // 해당 인덱스 삭제
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            root = root.next;
        } else {
            Node<T> cur = root;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            if (cur.next.next != null) {
                cur.next = cur.next.next;
            } else {
                cur.next = null;
            }
        }
        size--;
    }

    // 마지막 노드에 data 추가
    public void add(T data) {
        size++;
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> cur = root;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(data);
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> cur = root;
        if (size == 0) return "null";
        str += root.data + " ";
        while (cur.next != null) {
            str += cur.next.data + " ";
            cur = cur.next;
        }
        return str;
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {

        private Node<T> cur;

        public MyLinkedListIterator() {
            this.cur = root;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            if (cur == null) {
                throw new NoSuchElementException();
            }
            T data = cur.data;
            cur = cur.next;
            return data;
        }
    }
}
