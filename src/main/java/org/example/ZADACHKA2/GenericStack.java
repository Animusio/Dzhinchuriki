package org.example.ZADACHKA2;
import java.util.ArrayList;
import java.util.EmptyStackException;

//ЗАДАНИЕ 2
// Напишите обобщенный класс GenericStack, который представляет собой стек,
// поддерживающий операции push, pop и peek.
// Используйте массив для внутреннего хранения элементов.














//Решение -
//public class GenericStack<T> {
//    private ArrayList<T> elements;
//
//    public GenericStack() {
//        elements = new ArrayList<>();
//    }
//    private void push(T item) {
//        elements.add(item);
//    }
//
//    private T pop() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//        return elements.remove(elements.size() - 1);
//    }
//    private T peek() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//        return elements.get(elements.size() - 1);
//    }
//    private boolean isEmpty() {
//        return elements.isEmpty();
//    }
//}
