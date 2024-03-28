package org.example.ZADACHKA5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ЗАДАНИЕ 5
// Вы разрабатываете систему учета сотрудников в компании.
// Ваша задача - создать обобщенный класс EmployeeRegistry, который будет хранить информацию о сотрудниках компании.
// Каждый сотрудник имеет уникальный идентификатор (ID) и полное имя.
//
// Реализуйте класс EmployeeRegistry<T>, который будет представлять собой реестр сотрудников.
// Каждый сотрудник будет представлен объектом класса Employee, содержащим поля id и name.
// Класс EmployeeRegistry должен предоставлять методы для -
// добавления сотрудника, удаления сотрудника, получения сотрудника по его ID и получения списка всех сотрудников.









//Решение -
public class EmployeeRegistry<T extends Employee> {
    private Map<Integer, T> employees;

    public EmployeeRegistry() {
        employees = new HashMap<>();
    }

    private void add(T employee) {
        employees.put(employee.getId(), employee);
    }

    private void remove(int id) {
        employees.remove(id);
    }

    private T getEmployeeById(int id) {
        return employees.get(id);
    }

    private List<T> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
}

