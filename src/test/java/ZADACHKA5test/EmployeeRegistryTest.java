package ZADACHKA5test;

import org.example.ZADACHKA5.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
public class EmployeeRegistryTest {

    @Test
    public void testMethods() throws Exception {
        Class<?> classobj = null;
        try {
            classobj = Class.forName("org.example.ZADACHKA5.EmployeeRegistry");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {
            Constructor<?> constructor = classobj.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object employeeRegistryInstance = constructor.newInstance();

            Method addMethod = classobj.getDeclaredMethod("add", Employee.class);
            Method removeMethod = classobj.getDeclaredMethod("remove", int.class);
            Method getEmployeeByIdMethod = classobj.getDeclaredMethod("getEmployeeById", int.class);
            Method getAllEmployeesMethod = classobj.getDeclaredMethod("getAllEmployees");

            addMethod.setAccessible(true);
            removeMethod.setAccessible(true);
            getEmployeeByIdMethod.setAccessible(true);
            getAllEmployeesMethod.setAccessible(true);

            Employee employee1 = new Employee(1, "John Doe");
            addMethod.invoke(employeeRegistryInstance, employee1);

            Employee retrievedEmployee = (Employee) getEmployeeByIdMethod.invoke(employeeRegistryInstance, 1);

            List<Employee> allEmployees = (List<Employee>) getAllEmployeesMethod.invoke(employeeRegistryInstance);

            Assertions.assertEquals(employee1, retrievedEmployee);
            Assertions.assertEquals(1, allEmployees.size());

            removeMethod.invoke(employeeRegistryInstance, 1);

            Employee nullEmployee = (Employee) getEmployeeByIdMethod.invoke(employeeRegistryInstance, 1);
            Assertions.assertNull(nullEmployee);


        } catch (NoSuchMethodException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ ошибка в методе");
        }
        catch (InvocationTargetException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ вызываемый метод вызывает исключение");
        }
        catch (InstantiationException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ не удалось создать объект класса");
        }
        catch (IllegalAccessException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ нелегальная доступа к члену класса (полям, методам или конструкторам)");
        }
    }
}

