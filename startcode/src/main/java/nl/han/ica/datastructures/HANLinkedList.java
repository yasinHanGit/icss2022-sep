package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {

    private Node<T> first = null;
    private int size = 0;


    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node<T> node = first;
        Node<T> newNode = new Node<>(value);
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    public void delete(int pos) {
        if (pos < 0 || pos >= size) return;
        if (pos == 0) {
            removeFirst();
        } else {
            Node<T> node = first;
            for (int i = 0; i < pos - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            size--;
        }

    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size) return null;

        Node<T> node = first;
        for (int i = 0; i < pos; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void removeFirst() {
        if (size <= 0) return;
        first = first.next;
        size--;
    }

    @Override
    public T getFirst() {
        if (first == null) return null;
        return first.data;
    }

    @Override
    public int getSize() {
        return size;
    }
}
