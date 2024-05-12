public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        linkedList.delete(1);

        System.out.println(linkedList.get(2));

        System.out.println(linkedList);

        for (String string : linkedList) {
            System.out.println(string);
        }

        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        MyStack<Character> s = new MyStack<>();

        s.push('가');
        s.push('나');
        s.push('다');
        s.push('라');

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}