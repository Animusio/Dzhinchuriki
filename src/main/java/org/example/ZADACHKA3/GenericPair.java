package org.example.ZADACHKA3;
import java.util.ArrayList;
import java.util.EmptyStackException;

//ЗАДАНИЕ 3
// Напишите обобщенный класс GenericPair, который представляет собой пару значений любых типов,
// Класс должен иметь два поля для хранения этих значений и конструктор для их инициализации.
// Также предоставьте методы для доступа к каждому значению в паре.






//Решение -
public class GenericPair<T, U> {
    private T first;
    private U second;

    public GenericPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
