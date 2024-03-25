package org.example.ZADACHKA1;



//ЗАДАНИЕ 1
//Переделайте обычный класс хранилище(Storage) в обобщенный(GenericStorage) чтобы он смог принимать не только строки

/*
public class Storage {
    private String item;

    public void addItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
    @Override
    public String toString() {
        return "Storage{" +
                "item=" + item +
                '}';
    }
}
*/








//Решение -

public class GenericStorage<T> {
    private T item;

    public void addItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "item=" + item +
                '}';
    }
}

