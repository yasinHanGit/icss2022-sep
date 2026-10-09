package nl.han.ica.datastructures;

import java.util.ArrayList;

public class HanStack<T> implements IHANStack<T> {

    private ArrayList<T> list;

    public HanStack(){
        list = new ArrayList<>();
    }


    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        T temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        return temp;
    }

    @Override
    public T peek() {
        return list.get(list.size()-1);
    }
}
