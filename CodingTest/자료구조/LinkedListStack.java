// Node 클래스 정의
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Stack 클래스 정의
public class LinkedListStack<T> {
    private Node<T> top;

    public LinkedListStack() {
        this.top = null;
    }

    // 스택에 요소 추가 (Push)
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    // 스택에서 요소 제거 및 반환 (Pop)
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // 스택의 최상단 요소 반환 (Peek)
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비어 있습니다.");
        }
        return top.data;
    }

    // 스택이 비어 있는지 확인
    public boolean isEmpty() {
        return top == null;
    }

    // 스택 출력 (디버깅 용도)
    public void display() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // 메인 메서드 예제
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // 출력: 30 20 10

        System.out.println("Pop: " + stack.pop()); // 출력: Pop: 30
        stack.display(); // 출력: 20 10

        System.out.println("Peek: " + stack.peek()); // 출력: Peek: 20
        stack.display(); // 출력: 20 10
    }
}
