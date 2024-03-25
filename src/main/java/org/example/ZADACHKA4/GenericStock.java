package org.example.ZADACHKA4;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//ЗАДАНИЕ4
//Вы разрабатываете систему управления товарными запасами для небольшого магазина.
// Ваша задача - создать обобщенный класс Stock,
// который будет хранить информацию о количестве товаров на складе.
// Однако, важно учитывать, что для каждого товара на складе должен быть уникальный идентификатор.
// Реализуйте класс GenericStock, который будет представлять собой запас товаров на складе.
// Каждый товар должен иметь уникальный идентификатор, а количество товара может быть различным.
// Класс должен предоставлять методы для добавления товара на склад, удаления товара со склада, получения количества товара по его идентификатору и получения списка всех товаров на складе.









//Решение -
public class GenericStock<T> {

    private Map<T, Integer> items;

    public GenericStock() {
        items = new HashMap<>();
    }

    public void add(T itemId, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        items.put(itemId, quantity);
    }

    public void remove(T itemId) {
        items.remove(itemId);
    }

    public int getQuantity(T itemId) {
        Integer quantity = items.get(itemId);
        return quantity != null ? quantity : 0;
    }

    public Set<T> getAllItems() {
        return items.keySet();
    }
}

