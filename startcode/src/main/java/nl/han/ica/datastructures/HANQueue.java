package nl.han.ica.datastructures;

import java.util.ArrayList;

public class HANQueue<T> implements IHANQueue<T>{
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void clear() {
        list = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() {
        T temp = list.get(list.size()-1);;;
        list.remove(list.size()-1);
        return temp;
    }

    @Override
    public T peek() {
        return list.get(list.size()-1);
    }

    @Override
    public int getSize() {
        return list.size();
    }
}
