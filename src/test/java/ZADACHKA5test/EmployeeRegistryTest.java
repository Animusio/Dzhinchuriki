package ZADACHKA5test;

import org.example.ZADACHKA5.Employee;
import org.example.ZADACHKA5.EmployeeRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeRegistryTest {
    private EmployeeRegistry<Employee> registry = new EmployeeRegistry<>();


    @Test
    public void testAddAndGetEmployee() {
        Employee employee = new Employee(1, "John Doe");
        registry.add(employee);
        Assertions.assertEquals(employee, registry.getEmployeeById(1));
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee(2, "Jane Smith");
        registry.add(employee);
        registry.remove(2);
        Assertions.assertNull(registry.getEmployeeById(2));
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee(1, "John Doe");
        Employee employee2 = new Employee(2, "Jane Smith");
        registry.add(employee1);
        registry.add(employee2);
        Assertions.assertEquals(2, registry.getAllEmployees().size());
    }
}
