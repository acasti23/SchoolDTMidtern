public class MyGenericList<T extends Comparable<T>> {
    private class Node<T> {
        T value;
        Node<T> next;
    }

    private Node<T> first = null;
    int count = 0;

    public void add(T element) {
        Node<T> newnode = new Node<T>();
        newnode.value = element;
        newnode.next = null;
        if (first == null) {
            first = newnode;
        } else {
            Node<T> lastnode = gotolastnode(first);
            lastnode.next = newnode;
        }
        count++;
    }

    public T get(int pos) {
        Node<T> Nodeptr = first;
        int hopcount = 0;
        while (hopcount < count && hopcount < pos) {
            if (Nodeptr != null) {
                Nodeptr = Nodeptr.next;
            }
            hopcount++;
        }
        return Nodeptr.value;
    }

    private Node<T> gotolastnode(Node<T> nodepointer) {
        if (nodepointer == null) {
            return nodepointer;
        } else {
            if (nodepointer.next == null)
                return nodepointer;
            else
                return gotolastnode(nodepointer.next);
        }
    }

    public void delete(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node<T> Nodeptr = first;
            Node<T> prevNode = null;
            int indCount = 0;
            while (indCount < count && indCount < index) {
                if (Nodeptr != null) {
                    prevNode = Nodeptr;
                    Nodeptr = Nodeptr.next;
                }
                indCount++;
            }
            if (Nodeptr != null) {
                prevNode.next = Nodeptr.next;
            }
        }
        count--;
    }

    public void add(int index, T element) {
        Node<T> newNode = new Node<T>();
        newNode.value = element;
        newNode.next = null;
        if (first == null) {
            first = newNode;
        } else {
            Node<T> Nodeptr = first;
            Node<T> prevNode = null;
            int inCount = 0;
            // stops at the before the position to insert the new node
            while (inCount < count && inCount < index) {
                if (Nodeptr != null) {
                    prevNode = Nodeptr;
                    Nodeptr = Nodeptr.next;
                }
                inCount++;
            }
            if (prevNode == null) {
                newNode.next = first;
                first = newNode;
            } else {
                prevNode.next = newNode;
                newNode.next = Nodeptr;
            }
        }
        count++;
    }
}
class EmptyFieldException extends Exception {
    EmptyFieldException(String message) {
       super(message);
    }
 }