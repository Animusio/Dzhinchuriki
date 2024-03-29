package ZADACHKA5test;

import org.example.ZADACHKA5.Employee;
import org.example.ZADACHKA5.EmployeeRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
public class EmployeeRegistryTest {

    @Test
    public void testMethods() throws Exception {
        EmployeeRegistry<Employee> registry = new EmployeeRegistry<>();

        Field employeesField = EmployeeRegistry.class.getDeclaredField("employees");
        employeesField.setAccessible(true);
        Map<Integer, Employee> employees = (Map<Integer, Employee>) employeesField.get(registry);
        Assertions.assertTrue(employees.isEmpty());

        Employee employee = new Employee(1, "John Doe");
        Method addMethod = EmployeeRegistry.class.getDeclaredMethod("add", Employee.class);
        addMethod.setAccessible(true);
        addMethod.invoke(registry, employee);
        Assertions.assertEquals(employee, employees.get(1));

        Method removeMethod = EmployeeRegistry.class.getDeclaredMethod("remove", int.class);
        Method getEmployeeByIdMethod = EmployeeRegistry.class.getDeclaredMethod("getEmployeeById", int.class);
        Method getAllEmployeesMethod = EmployeeRegistry.class.getDeclaredMethod("getAllEmployees");
        removeMethod.setAccessible(true);
        getEmployeeByIdMethod.setAccessible(true);
        getAllEmployeesMethod.setAccessible(true);

        removeMethod.invoke(registry, 1);

        Assertions.assertNull(getEmployeeByIdMethod.invoke(registry, 1));

        List<Employee> allEmployees = (List<Employee>) getAllEmployeesMethod.invoke(registry);
        Assertions.assertTrue(allEmployees.isEmpty());
    }
}

