package list.arraylist.implementation;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];

    public boolean addFirst(Object element) {
        return add(0, element);
    }

    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, Object element) {
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    public Object remove(int index) {
        Object removeElement = elementData[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removeElement;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        return "[" + Arrays.stream(elementData).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}