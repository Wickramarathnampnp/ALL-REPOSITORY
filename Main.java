import static java.lang.System.exit;

class Array_Implement {
    public int[] push1(int[] S, int x) {
        int n = S.length;
        int S_size = 10;
        int S_top = n - 1;
        S_top = S_top + 1;
        if (S_size < S_top) {
            System.out.println("Error : Stack overflow");
        }
        else {
            S[S_top] = x;
        }
        return S;
    }
    public int[] pop1(int[] S) {
        int S_top = S.length - 1;
        if (S.length == 0) {
            System.out.println("Stack underflow");
        }
        int[] anotherArray = new int[S.length - 1];
        System.arraycopy(S, 0, anotherArray, 0, S_top);
        System.arraycopy(S, S_top + 1,
                anotherArray, S_top,
                S.length - S_top - 1);
        S = anotherArray;
        return S;
    }
    public void display1(int[] S) {
        for (int i = 0; i < S.length; i++) {
            System.out.println(S[i] + "\n");
        }
    }
}
class Linked_Implement {
    private class Node {
        int data;
        Node link;
    }
    Node top;
    Linked_Implement() { this.top = null; }
    public void push2(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.link = top;
        top = temp;
    }
    public void pop2() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
        top = (top).link;
    }
    public void display2() {
        if (top == null) {
            System.out.println("\nStack Underflow");
            exit(1);
        }
        else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + "\n");
                temp = temp.link;
            }
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Array_Implement obj_1 = new Array_Implement();
        Linked_Implement obj_2 = new Linked_Implement();
        long start1 = System.nanoTime();
        obj_2.push2(8);
        obj_2.push2(10);
        obj_2.push2(5);
        obj_2.push2(11);
        obj_2.push2(15);
        obj_2.push2(23);
        obj_2.push2(6);
        obj_2.push2(18);
        obj_2.push2(20);
        obj_2.push2(17);
        obj_2.display2();
        for (int i = 0; i < 5; i++) {
            obj_2.pop2();
        }
        obj_2.display2();
        obj_2.push2(4);
        obj_2.push2(30);
        obj_2.push2(3);
        obj_2.push2(1);
        obj_2.display2();
        long end1 = System.nanoTime();
        long final1 = end1 - start1;
        System.out.println("Execution time of linked list implementation of stack is : " + final1 + "ns");
        int[] S = { 0 };
        long start2 = System.nanoTime();
        obj_1.push1(S, 8);
        obj_1.push1(S, 10);
        obj_1.push1(S, 5);
        obj_1.push1(S, 11);
        obj_1.push1(S, 15);
        obj_1.push1(S, 23);
        obj_1.push1(S, 6);
        obj_1.push1(S, 18);
        obj_1.push1(S, 20);
        obj_1.push1(S, 17);
        obj_1.display1(S);
        for (int i = 0; i < 5; i++) {
            obj_1.pop1(S);
        }
        obj_1.display1(S);
        obj_1.push1(S, 4);
        obj_1.push1(S, 30);
        obj_1.push1(S, 3);
        obj_1.push1(S, 1);
        obj_1.display1(S);
        long end2 = System.nanoTime();
        long final2 = end2 - start2;
        System.out.println("Execution time of array implementation of stack is : " + final2 + "ns");
    }
}