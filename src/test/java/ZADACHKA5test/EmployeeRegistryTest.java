package ZADACHKA5test;

import org.example.ZADACHKA5.Employee;
import org.example.ZADACHKA5.EmployeeRegistry;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
public class EmployeeRegistryTest {

    @Test
    public void testMethods() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Создаем экземпляр класса EmployeeRegistry
        EmployeeRegistry<Employee> registry = new EmployeeRegistry<>();

        // Получаем доступ к приватному полю employees с помощью рефлексии
        Field employeesField = EmployeeRegistry.class.getDeclaredField("employees");
        employeesField.setAccessible(true);
        Map<Integer, Employee> employees = (Map<Integer, Employee>) employeesField.get(registry);

        // Проверяем, что employees пустой
        assertTrue(employees.isEmpty());

        // Создаем и добавляем сотрудника в реестр
        Employee employee = new Employee(1, "John Doe");
        Method addMethod = EmployeeRegistry.class.getDeclaredMethod("add", Employee.class);
        addMethod.setAccessible(true);
        addMethod.invoke(registry, employee);

        // Проверяем, что сотрудник добавлен
        assertEquals(employee, employees.get(1));

        // Получаем доступ к приватным методам remove, getEmployeeById и getAllEmployees
        Method removeMethod = EmployeeRegistry.class.getDeclaredMethod("remove", int.class);
        Method getEmployeeByIdMethod = EmployeeRegistry.class.getDeclaredMethod("getEmployeeById", int.class);
        Method getAllEmployeesMethod = EmployeeRegistry.class.getDeclaredMethod("getAllEmployees");
        removeMethod.setAccessible(true);
        getEmployeeByIdMethod.setAccessible(true);
        getAllEmployeesMethod.setAccessible(true);

        // Удаляем сотрудника по его идентификатору
        removeMethod.invoke(registry, 1);

        // Проверяем, что сотрудник удален
        assertNull(getEmployeeByIdMethod.invoke(registry, 1));

        // Проверяем, что метод getAllEmployees возвращает пустой список после удаления
        List<Employee> allEmployees = (List<Employee>) getAllEmployeesMethod.invoke(registry);
        assertTrue(allEmployees.isEmpty());
    }
}

